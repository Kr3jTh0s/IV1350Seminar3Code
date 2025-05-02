package processSale.controller;

import processSale.integration.*;
import processSale.view.*;
import processSale.model.*;
import processSale.model.dto.*;

/**
 * The Controller class is responsible for managing the flow of the
 * application. It acts as a mediator between different layers,
 * handling user input and updating the model, view and integration
 * accordingly.
 */
public class Controller {
    private View view;
    private Printer printer;
    private Inventory inv;
    private Discount disc;
    private Account acc;
    private Sale currentSale;

    /**
     * Creates a new instance of the Controller class, initializing the
     * external system dependencies required for processing sales.
     * 
     * @param printer The printer instance used for printing receipts.
     * @param inv     The inventory system instance used for retrieving item
     *                information.
     * @param disc    The discount database instance used for applying discounts.
     * @param acc     The accounting system instance used for recording
     *                transactions.
     */
    public Controller(Printer printer, Inventory inv, Discount disc, Account acc) {
        this.printer = printer;
        this.inv = inv;
        this.disc = disc;
        this.acc = acc;
    }

    /**
     * Sets the view instance for the controller. This allows the controller
     * to communicate with the view layer and update it as needed.
     * 
     * @param view The view instance to be set.
     */
    public void setView(View view) {
        this.view = view;
    }

    /**
     * 
     */
    public void startSale() {
        currentSale = new Sale();
        printer.createReceipt(currentSale.getTimeOfSale());
    }

    /**
     * Registers an item in the current sale by its unique identifier. If the item
     * does not already exist in the current sale, it retrieves the item information
     * from the inventory system and adds it to the sale.
     * 
     * @param itemID The unique identifier of the item to be registered.
     */
    public void registerItem(String itemID) {
        if (currentSale.itemExists(itemID)) {
            currentSale.increaseItemQuantity(itemID);
        } else {
            currentSale.addItem(inv.getItem(itemID));
        }
    }

    /**
     * 
     * @param customerID
     */
    public void endSale(String customerID) {
        double totalPrice = currentSale.getRunningTotal();
    }

    /**
     * 
     * @param amountPaid
     */
    public void processSale(double amountPaid) {
        SaleSummaryDTO saleSummary = currentSale.processSale(amountPaid);
        printer.printReceipt(saleSummary);
        inv.updateInventory(saleSummary);
        acc.accountSale(saleSummary);
    }
}
