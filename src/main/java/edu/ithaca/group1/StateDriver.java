package edu.ithaca.group1;

public class StateDriver {
    private State currentState;
    private boolean quit = false;

    public void start(StateStatus state)
    {
        changeState(state);
        while (!quit)
        {
            currentState.run();
            if (currentState.getCompleted())
            {
                changeState(currentState.getNextState());
            }
        }
    }

    private void changeState(StateStatus newState)
    {
        switch (newState)
        {
            case MANAGER:
                currentState = new Manager();
                break;

            case SECURITY:
                currentState = new Security();
                break;

            case MAINMENU:
                currentState = new MainMenu();
                break;

            case QUIT:
                quit = true;
        }
    }
}
