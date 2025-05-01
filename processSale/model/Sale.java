package processSale.model;

import processSale.model.dto.*;

/**
 * Represents a sale transaction, including details such as the time of sale,
 * items purchased, running total, and VAT. This class provides methods to
 * manage and retrieve information about the sale.
 */
public class Sale {
    private TimeOfSaleDTO timeOfSale;
    private ItemHandler items;
    private BoughtItemsDTO boughtItems;
    private SaleSummaryDTO saleSummary; // may not need to be here yet
    private double runningTotal;
    private double totalVAT;
    private double discount;

    /**
     * Creates a new instance of the Sale class, initializing the time of sale
     * and the item handler. The time of sale is represented by a TimeOfSaleDTO
     * object, which is created using the provided date and time.
     * 
     * @param date The date of the sale in string format.
     * @param time The time of the sale in string format.
     */
    public Sale(String date, String time) {
        timeOfSale = new TimeOfSaleDTO(date, time);
        items = new ItemHandler();
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
        return items.findItem(itemID);
    }

    /**
     * Adds an item to the current sale.
     * 
     * @param item The {@link ItemDTO} object representing the item to be added
     *             to the sale.
     */
    public void addItem(ItemDTO item) {
        items.addItem(item);
    }
}