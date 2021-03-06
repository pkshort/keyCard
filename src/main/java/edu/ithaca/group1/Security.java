package edu.ithaca.group1;

import java.util.ArrayList;

public class Security extends State{

    private String menuOptions = "View Pending Requests,Approve Request,Deny Request,Return to Main Menu";

    public Security(){ }

    public void run()
    {
        int selection = -1;
        while(selection != 3) {
            super.myConsole.listOptions(menuOptions);
            selection = super.myConsole.getInputOption(menuOptions);
            branchApp(selection);
        }
    }

    /**
     * branch app acts as a main menu for the Security class. Each case corresponds to a different
     * operation listed in the options from the security class
     * @param option input from user corresponding to an option
     */
    public void branchApp(int option)
    {
        switch(option){
            case 0:
                viewPendingRequests();
                break;
            case 1:
                approveRequest();
                break;
            case 2:
                denyRequest();
                break;
            case 3:
                System.out.println("Returning to main menu...");
                super.setCompleted(true);
                super.setNextState(StateStatus.MAINMENU);
                break;
        }
    }

    /**
     * Prints out a list of requests that are awaiting approval from the security rep
     */
    public void viewPendingRequests()
    {
        ArrayList<Request> allRequests = myDAO.getAllRequests();
        ArrayList<Request> pending = new ArrayList<Request>();

        for (int i = 0; i < allRequests.size(); i++) {
            Request req = allRequests.get(i);
            if (req.getStatus() == RequestStatus.NEW)
            {
                pending.add(req);
            }
        }
        if (pending.size() > 0)
        {
            System.out.println("\nPermission requests waiting approval:\n");
            myConsole.printRequests(pending);
        }
        else
        {
            System.out.println("No pending permission requests.");
        }

    }

    /**
     * Approves a request from the list of pending requests
     */
    public void approveRequest()
    {
        System.out.println("Enter the request ID");
        String requestId = myConsole.getInputString();
        Request req = myDAO.getRequestById(requestId);
        if (req != null)
        {
            if (req.getStatus() == RequestStatus.NEW)
            {
                myDAO.updateRequest(requestId, RequestStatus.SECURITY_CLEARED);
                System.out.println("Request #" + req.getId() + " has been cleared for manager approval.\n");
            }
            else
            {
                System.out.println("Request #" + req.getId() + " does not need approval at this time.");
            }
        }
        else
        {
            System.out.println("No request with id: " + requestId + " found.");
        }
    }

    /**
     * Denies a request from the list of pending requests
     */
    public void denyRequest()
    {
        System.out.println("Enter the request ID");
        String requestId = myConsole.getInputString();
        Request req = myDAO.getRequestById(requestId);
        if (req != null)
        {
            if (req.getStatus() == RequestStatus.NEW)
            {
                myDAO.updateRequest(requestId, RequestStatus.DENIED);
                System.out.println("Request #" + req.getId() + " has been denied.\n");
            }
            else
            {
                System.out.println("Request #" + req.getId() + " cannot be denied at this time.");
            }
        }
        else
        {
            System.out.println("No request with id: " + requestId + " found.");
        }
    }
}
