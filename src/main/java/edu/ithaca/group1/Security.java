package edu.ithaca.group1;

public class Security extends State{

    private boolean approved = false;
    private String options = "View Pending Requests,Approve Request,Deny Request";

    public Security(StateStatus myState)
    {
        super(myState);
    }

    /**
     * Prints out a list of requests that are awaiting approval from the security rep
     */
    public void viewPendingRequests()
    {
        System.out.println("List of pending requests...");
    }

    /**
     * Approves a request from the list of pending requests
     * @return approved - status of approval should be true since request is approved
     */
    public boolean approveRequest()
    {
        this.approved = true;
        return approved;
    }

    /**
     * Denies a request from the list of pending requests
     * @return approved - status of approval should be false since request is denied
     */
    public boolean denyRequest()
    {
        this.approved = false;
        return approved;
    }
}
