package src.main.java.processSale.controller;

import src.main.java.processSale.integration.*;
import src.main.java.processSale.model.*;
import src.main.java.processSale.model.dto.*;

/**
 * The Controller class manages the flow of the application. It acts as a
 * mediator between the view, model, and integration layers, handling user
 * input and coordinating updates across the system.
 */
public class Controller {
    private Printer printer;           // Handles receipt printing
    private Inventory inventorySystem; // Manages inventory operations
    private Discount discountDatabase; // Handles discount operations
    private Account accountingSystem;  // Handles accounting operations
    private Sale currentSale;          // Represents the ongoing sale

    /**
     * Initializes the Controller with the required external system dependencies.
     * 
     * @param printer   The printer instance for printing receipts.
     * @param inventory The inventory system for retrieving item information.
     * @param discount  The discount system for applying discounts.
     * @param account   The accounting system for recording transactions.
     */
    public Controller(Printer printer, Inventory inventory, Discount discount, Account account) {
        this.printer = printer;
        this.inventorySystem = inventory;
        this.discountDatabase = discount;
        this.accountingSystem = account;
    }

    /**
     * Starts a new sale by creating a new `Sale` instance and initializing the
     * receipt.
     */
    public void startSale() {
        currentSale = new Sale();
        printer.createReceipt(currentSale.getTimeOfSale());
    }

    /**
     * Registers an item in the current sale. If the item already exists in the
     * sale, its quantity is increased. Otherwise, the item is retrieved from the
     * inventory system and added to the sale.
     *
     * @param itemID The unique identifier of the item to be registered.
     * @return The {@link ItemDTO} object representing the registered item, or
     *         {@code null} if not found in inventory.
     */
    public ItemDTO registerItem(String itemID) {
        if (currentSale.itemExists(itemID)) {
            return currentSale.increaseItemQuantity(itemID);
        }

        ItemDTO item = inventorySystem.getItem(itemID);
        if (item != null) {
            currentSale.addItem(item);
        }
        return item;
    }

    public String getTotals() {
        return currentSale.getTotals();
    }

    /**
     * Ends the current sale and calculates the total price. This method can be
     * extended to include additional operations, such as applying discounts or
     * notifying the view.
     *
     * @param customerID The unique identifier of the customer (currently unused).
     * @return The total price of the sale as a double.
     */
    public double endSale(String customerID) {
        return currentSale.getRunningTotal();
        // Future extension: Apply discounts or notify the view
    }

    /**
     * Processes the sale by finalizing payment, printing the receipt, and updating
     * the inventory and accounting systems.
     * 
     * @param amountPaid The amount paid by the customer.
     */
    public void processSale(double amountPaid) {
        SaleSummaryDTO saleSummary = currentSale.processSale(amountPaid);
        printer.printReceipt(saleSummary);
        inventorySystem.updateInventory(saleSummary);
        accountingSystem.accountSale(saleSummary);
    }
}
