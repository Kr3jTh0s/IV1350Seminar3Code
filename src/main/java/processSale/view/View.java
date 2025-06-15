package src.main.java.processSale.view;

import java.util.Scanner;

import src.main.java.processSale.controller.Controller;
import src.main.java.processSale.model.dto.ItemDTO;

/**
 * The View class represents the user interface layer of the application.
 * It interacts with the Controller to perform operations and display
 * information to the user. This class is responsible for initiating
 * actions and passing user inputs to the Controller.
 */
public class View {
    private final Controller controller; // The controller instance used by this view
    private final TestView testing;      // A helper class for testing user interactions

    /**
     * Creates a new instance of the View class and sets up the connection
     * with the Controller. The Controller is provided as a parameter and
     * is used to delegate operations initiated by the View.
     *
     * @param controller The controller instance to be used by this view.
     */
    public View(Controller controller) {
        this.controller = controller;
        testing = new TestView(controller, this);
    }

    /**
     * Starts the user interaction by delegating to the TestView class.
     */
    public void awaitInputs() {
        testing.awaitInputs();
    }

    public void itemNotFound(String itemID) {
        System.out.println("Item not found in inventory: " + itemID);
    }

    public void displayTotalPrice(double totalPrice) {
        System.out.printf("Sale ended. Total price: %.2f SEK%n", totalPrice);
    }

    public void displayAddedItem(String addedItem) {
        System.out.println(addedItem);
        System.out.println(controller.getTotals());
    }

    /**
     * Creates a printout of the details of an added or updated item.
     * 
     * @param item The {@link ItemDTO} object representing the item.
     * @return The id, name, price, VAT and description of the added item
     *         as a string.
     */
    public void printAddedItem(ItemDTO item) {
        displayAddedItem(String.format("Added 1 item with ID %s:%n" +
                "Item Name: %s%n" +
                "Price: %.2f SEK%n" +
                "VAT: %.0f%%%n" +
                "Description: %s%n",
                item.getID(), item.getName(), item.getPrice(), item.getVATRate() * 100, item.getDescription()));
    }
}

/**
 * The TestView class handles user input for testing purposes.
 * It provides a simple console-based interface for interacting with the system.
 */
class TestView {
    private final Controller controller;
    private final Outputs out = new Outputs();
    private final View view;

    private enum StartInputs {
        AUTO, START, EXIT
    }

    private enum RegisterInputs {
        END, EXIT
    }

    /**
     * Helper class for printing prompts and messages.
     */
    private static class Outputs {
        void printAwaitStart() {
            System.out.println("""
                    Enter:
                    AUTO - to automate real quick
                    START - to start new sale
                    EXIT - to exit program
                    """);
        }

        void printAwaitRegister() {
            System.out.println("""
                    Enter:
                    [item identifier] - to register item
                    END - to end sale
                    EXIT - to exit program
                    """);
        }

        void printAwaitPayment() {
            System.out.println("Enter: \n[payment] - to process payment\n");
        }

        void printInvalidInput() {
            System.out.println("Invalid input.");
        }
    }

    /**
     * Creates the TestView.
     *
     * @param controller The controller instance.
     * @param view       The main view instance.
     */
    public TestView(Controller controller, View view) {
        this.controller = controller;
        this.view = view;
    }

    /**
     * Main loop for handling user input and navigating between stages.
     */
    public void awaitInputs() {
        try (Scanner scanner = new Scanner(System.in)) {
            int stage = 1;
            while (true) {
                switch (stage) {
                    case 1 -> stage = handleStartMenu(scanner);
                    case 2 -> stage = handleRegisterMenu(scanner);
                    case 3 -> stage = handlePaymentMenu(scanner);
                    case 4 -> stage = autoRegister();
                    case 5 -> System.exit(0);
                }
            }
        }
    }

    /**
     * Handles the start menu input.
     */
    private int handleStartMenu(Scanner scanner) {
        out.printAwaitStart();
        String input = scanner.nextLine().trim();
        if (isValidInput(input, StartInputs.values())) {
            return switch (StartInputs.valueOf(input.toUpperCase())) {
                case AUTO -> 4;
                case START -> {
                    controller.startSale();
                    yield 2;
                }
                case EXIT -> 5;
            };
        }
        out.printInvalidInput();
        return 1;
    }

    /**
     * Handles the register menu input.
     */
    private int handleRegisterMenu(Scanner scanner) {
        out.printAwaitRegister();
        String input = scanner.nextLine().trim();
        if (isValidInput(input, RegisterInputs.values())) {
            return switch (RegisterInputs.valueOf(input.toUpperCase())) {
                case END -> {
                    controller.endSale("null");
                    yield 3;
                }
                case EXIT -> 5;
            };
        }
        registerItem(input);
        return 2;
    }

    /**
     * Handles the payment input.
     */
    private int handlePaymentMenu(Scanner scanner) {
        out.printAwaitPayment();
        String input = scanner.nextLine().trim();
        if (isValidDouble(input)) {
            controller.processSale(Double.parseDouble(input));
            return 1;
        }
        out.printInvalidInput();
        return 3;
    }

    private int autoRegister() {
        controller.startSale();

        registerItem("1");
        registerItem("5");
        registerItem("4");
        registerItem("1");
        registerItem("5");
        registerItem("3");

        view.displayTotalPrice(controller.endSale("null"));
        controller.processSale(700);
        return 1;
    }

    /**
     * Checks if the input matches any value in the given enum.
     */
    private boolean isValidInput(String input, Enum<?>[] validInputs) {
        for (Enum<?> valid : validInputs) {
            if (input.equalsIgnoreCase(valid.name())) {
                return true;
            }
        }
        return false;
    }

    private boolean isValidDouble(String input) {
        try {
            Double.parseDouble(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private void registerItem(String itemID) {
        ItemDTO item = controller.registerItem(itemID);
        if (item == null) {
            view.itemNotFound(itemID);
        } else {
            view.printAddedItem(item);
        }
    }
}