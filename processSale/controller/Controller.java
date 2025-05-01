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
     * Starts a new sale by creating a new Sale instance with the specified date and
     * time.
     * Also initializes the receipt creation process by using the printer to create
     * a receipt
     * with the time of the sale.
     * 
     * @param date The date when the sale is started, in the format "YYYY-MM-DD".
     * @param time The time when the sale is started, in the format "HH:MM".
     */
    public void startSale(String date, String time) {
        currentSale = new Sale(date, time);
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
        if (!currentSale.itemExists(itemID)) {
            currentSale.addItem(inv.getItem(itemID));
        }
    }

    /**
     * 
     */
    public void endSale(String customerID) {

    }

    /**
     * 
     */
    public void processPayment(double amountPaid) {

    }
}
