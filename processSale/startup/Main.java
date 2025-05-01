package processSale.startup;

import processSale.controller.*;
import processSale.integration.*;
import processSale.view.*;

/**
 * The Main class is the entry point of the application. It initializes the
 * necessary components such as the printer, inventory system, discount system,
 * and accounting system. These components are then passed to the Controller,
 * which manages the application's operations. The View is also initialized
 * to handle user interactions and start the process of awaiting inputs.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("yo");

        Printer printer = new Printer();
        Inventory inv = new Inventory();
        Discount disc = new Discount();
        Account acc = new Account();

        Controller contr = new Controller(printer, inv, disc, acc);
        View view = new View(contr);

        view.awaitInputs();
    }
}