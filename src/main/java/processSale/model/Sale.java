package src.main.java.processSale.model;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import src.main.java.processSale.model.dto.*;

/**
 * Represents a sale transaction, including details such as the time of sale,
 * items purchased, running total, and VAT. This class provides methods to
 * manage and retrieve information about the sale.
 */
public class Sale {
    private final TimeOfSaleDTO timeOfSale; // Stores the time when the sale was initiated
    private final ItemList items;           // Manages the list of items in the sale
    private double runningTotal;            // Tracks the total cost of items in the sale
    private double totalVAT;                // Tracks the total VAT for the sale

    /**
     * Initializes a new sale with the current time and an empty item list.
     */
    public Sale() {
        this.items = new ItemList();
        this.timeOfSale = new TimeOfSaleDTO(
                new SimpleDateFormat("yyyy-MM-dd_HH:mm").format(Calendar.getInstance().getTime()));
    }

    /**
     * Retrieves the time of the sale.
     * 
     * @return A {@link TimeOfSaleDTO} object representing the date and time
     *         when the sale was initiated.
     */
    public TimeOfSaleDTO getTimeOfSale() {
        return timeOfSale;
    }

    /**
     * Checks if an item exists in the current sale based on its item ID.
     * 
     * @param itemID The unique identifier of the item to check.
     * @return {@code true} if the item exists in the sale, otherwise {@code false}.
     */
    public boolean itemExists(String itemID) {
        return items.checkItem(itemID);
    }

    /**
     * Increases the quantity of an item in the current sale based on its item ID.
     * If the item does not exist in the sale, no action is taken.
     * 
     * @param itemID The unique identifier of the item whose quantity is to be
     *               increased.
     */
    public void increaseItemQuantity(String itemID) {
        if (items.checkItem(itemID)) {
            items.increaseQuantity(itemID);
            updateSale(items.getItem(itemID));
        }
    }

    /**
     * Adds a new item to the current sale and updates the sale totals.
     * 
     * @param item The {@link ItemDTO} object representing the item to be added.
     */
    public void addItem(ItemDTO item) {
        items.addNewItem(item);
        updateSale(item);
    }

    /**
     * Updates the running total and VAT for the sale based on the given item.
     * 
     * @param item The {@link ItemDTO} object used to update the totals.
     */
    private void updateSale(ItemDTO item) {
        runningTotal += item.getPrice(); // Add item price to the running total
        totalVAT += item.getPrice() * item.getVATRate(); // Add VAT for the item
        printSale(); // Print the updated sale summary
    }

    /**
     * Prints the current sale summary, including the total cost and VAT.
     */
    private void printSale() {
        System.out.printf("Total cost (incl. VAT): %.2f SEK%n", runningTotal);
        System.out.printf("Total VAT: %.2f SEK%n%n", totalVAT);
    }

    /**
     * Retrieves the current running total for the sale.
     * 
     * @return The running total as a double.
     */
    public double getRunningTotal() {
        return runningTotal;
    }

    /**
     * Processes the sale by finalizing payment and generating a summary.
     * 
     * @param amountPaid The amount paid by the customer.
     * @return A {@link SaleSummaryDTO} containing the sale details, payment info,
     *         and purchased items.
     */
    public SaleSummaryDTO processSale(double amountPaid) {
        ProcessPayment processedPayment = new ProcessPayment(amountPaid, runningTotal);
        PaymentInfoDTO paymentInfo = new PaymentInfoDTO(
                amountPaid,
                processedPayment.getChange(),
                runningTotal,
                totalVAT);
        return new SaleSummaryDTO(timeOfSale, items.getBoughtItemsDTO(), paymentInfo);
    }
}