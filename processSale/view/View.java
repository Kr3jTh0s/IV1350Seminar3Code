package processSale.view;

import processSale.controller.*;

/**
 * The View class represents the user interface layer of the application.
 * It interacts with the Controller to perform operations and display
 * information to the user. This class is responsible for initiating
 * actions and passing user inputs to the Controller.
 */
public class View {
    private Controller contr;

    /**
     * Creates a new instance of the View class and sets up the connection
     * with the Controller. The Controller is provided as a parameter and
     * is used to delegate operations initiated by the View.
     *
     * @param contr The controller instance to be used by this view.
     */
    public View(Controller contr) {
        this.contr = contr;
        contr.setView(this);
    }

    /**
     * Something random idk
     */
    public void awaitInputs() {
        System.out.println("yo");
        startSale();
    }

    /**
     * Signals the controller to start a new sale by passing
     * the current time and date to the controller.
     */
    public void startSale() {
        contr.startSale();
        contr.registerItem("1"); 
        contr.registerItem("5");
        contr.registerItem("4");
        contr.registerItem("1");
        contr.registerItem("5");
        contr.registerItem("3");
        contr.endSale("null");
        contr.processSale(400);
    }

}