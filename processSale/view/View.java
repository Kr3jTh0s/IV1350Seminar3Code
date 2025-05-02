package processSale.view;

import java.util.Scanner;
import processSale.controller.*;

/**
 * The View class represents the user interface layer of the application.
 * It interacts with the Controller to perform operations and display
 * information to the user. This class is responsible for initiating
 * actions and passing user inputs to the Controller.
 */
public class View {
    private Controller contr;
    private TestView testing;

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

        // Test
        testing = new TestView(contr, this);
    }

    /**
     * Something random idk
     */
    public void awaitInputs() {
        testing.awaitStartInputs();
    }

    /**
     * Signals the controller to start a new sale by passing
     * the current time and date to the controller.
     */
    private void startSale() {
        contr.startSale();
    }

}

// onödigt mycket för att testa xd
class TestView {
    private Controller contr;
    private View view;

    private enum StartInputs {
        AUTO,
        START,
        EXIT
    }

    private enum RegisterInputs {
        END,
        EXIT
    }

    public TestView(Controller contr, View view) {
        this.contr = contr;
        this.view = view;
    }

    public void awaitStartInputs() {
        Scanner inputScanner = new Scanner(System.in);
        boolean exit = false;
        while (!exit) {
            System.out.println("Enter: \n" +
                               "AUTO - to automate real quick\n" +
                               "START - to start new sale\n" +
                               "EXIT - to exit program\n");

            String userInput = inputScanner.nextLine();
            if (checkStartInputs(userInput)) {
                switch (getStartInput(userInput)) {
                    case AUTO:
                        autoRegister();
                        exit = true;
                        break;

                    case START:
                        startSale(inputScanner);
                        break;

                    case EXIT:
                        exit = true;
                        break;
                }
            } else {
                System.out.println("Invalid input.");
            }
        }
        inputScanner.close();
        System.exit(0);
    }

    private boolean checkStartInputs(String input) {
        for (StartInputs startInputs : StartInputs.values()) {
            if (input.equalsIgnoreCase(startInputs.name())) {
                return true;
            }
        }
        return false;
    }

    private StartInputs getStartInput(String input) {
        for (StartInputs startInputs : StartInputs.values()) {
            if (input.equalsIgnoreCase(startInputs.name())) {
                return startInputs;
            }
        }
        return null;
    }

    private void startSale(Scanner inputScanner) {
        contr.startSale();
        awaitRegisterInputs(inputScanner);
    }

    private void awaitRegisterInputs(Scanner inputScanner) {
        boolean exit = false;
        while (!exit) {
            System.out.println("Enter: \n" +
                               "[item identifier] - to register item\n" +
                               "END - to end sale\n" +
                               "EXIT - to exit program\n");

            String userInput = inputScanner.nextLine();
            if (checkStartInputs(userInput)) {
                switch (getRegisterInput(userInput)) {
                    case END:
                        contr.endSale("null");
                        awaitPaymentInput(inputScanner);
                        exit = true;
                        break;

                    case EXIT:
                        System.exit(0);
                        break;
                }
            } else {
                contr.registerItem(userInput);
            }
        }
    }

    private boolean checkRegisterInputs(String input) {
        for (RegisterInputs regInputs : RegisterInputs.values()) {
            if (input.equalsIgnoreCase(regInputs.name())) {
                return true;
            }
        }
        return false;
    }

    private RegisterInputs getRegisterInput(String input) {
        for (RegisterInputs regInputs : RegisterInputs.values()) {
            if (input.equalsIgnoreCase(regInputs.name())) {
                return regInputs;
            }
        }
        return null;
    }

    private void awaitPaymentInput(Scanner inputScanner) {
        boolean exit = false;
        while (!exit) {
            System.out.println("Enter: \n" +
                               "[payment] - to register item\n");

            String userInput = inputScanner.nextLine();
            if (checkPaymentInputs(userInput)) {
                contr.processSale(getPaymentInput(userInput));
                exit = true;
            } else {
                System.out.println("Invalid payment input.");
            }
        }
    }

    private boolean checkPaymentInputs(String input) {
        try {
            Double.parseDouble(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private Double getPaymentInput(String input) {
        return Double.parseDouble(input);
    }

    private void autoRegister() {
        contr.startSale();
        contr.registerItem("1");
        contr.registerItem("5");
        contr.registerItem("4");
        contr.registerItem("1");
        contr.registerItem("5");
        contr.registerItem("3");
        contr.endSale("null");
        contr.processSale(700);
    }
}