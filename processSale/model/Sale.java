package processSale.model;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import processSale.model.dto.*;

/**
 * Represents a sale transaction, including details such as the time of sale,
 * items purchased, running total, and VAT. This class provides methods to
 * manage and retrieve information about the sale.
 */
public class Sale {
    private TimeOfSaleDTO timeOfSale;
    private ItemList items;
    private double runningTotal;
    private double totalVAT;
    // private double discount;

    /**
     * 
     */
    public Sale() {
        items = new ItemList();
        timeOfSale = new TimeOfSaleDTO(new SimpleDateFormat("yyyy-MM-dd_HH:mm").format(Calendar.getInstance().getTime()));
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
     * @return {@code true} if the item exists in the sale, otherwise returns
     *         {@code false}.
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
        items.increaseQuantity(itemID);
        updateRunningTotal(items.getItem(itemID));
        updateVAT(items.getItem(itemID));
    }

    /**
     * Adds an item to the current sale.
     * 
     * @param item The {@link ItemDTO} object representing the item to be added
     *             to the sale.
     */
    public void addItem(ItemDTO item) {
        items.addNewItem(item);
        updateRunningTotal(item);
        updateVAT(item);
    }

    /**
     * 
     * @param item
     */
    private void updateRunningTotal(ItemDTO item){
        runningTotal += item.getPrice();
    }


    /**
     * 
     * @param item
     */
    private void updateVAT(ItemDTO item){
        totalVAT += (item.getPrice() * item.getVATRate());
    }

    /**
     * 
     * @return
     */
    public double getRunningTotal() {
        return runningTotal;
    }

    /**
     * 
     * @param amountPaid
     * @return
     */
    public SaleSummaryDTO processSale(double amountPaid){
        ProcessPayment processedPayment = new ProcessPayment(amountPaid, runningTotal);
        PaymentInfoDTO paymentInfo = new PaymentInfoDTO(amountPaid, processedPayment.getChange(), runningTotal, totalVAT);
        return new SaleSummaryDTO(timeOfSale, null, paymentInfo);
    }
}