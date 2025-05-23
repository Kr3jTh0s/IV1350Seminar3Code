package src.main.java.processSale.model;

import java.util.HashMap;

import src.main.java.processSale.model.dto.BoughtItemsDTO;
import src.main.java.processSale.model.dto.ItemDTO;

/**
 * Represents a list of items in a sale. This class manages the quantities
 * and metadata of items using two separate HashMaps.
 */
public class ItemList {
    private final HashMap<String, Integer> itemsQuantity; // Tracks item quantities by item ID
    private final HashMap<String, ItemDTO> itemsMeta;     // Stores item metadata by item ID

    /**
     * Initializes an empty item list.
     */
    public ItemList() {
        itemsQuantity = new HashMap<>();
        itemsMeta = new HashMap<>();
    }

    /**
     * Checks if an item exists in the list based on its item ID.
     * 
     * @param itemID The unique identifier of the item.
     * @return {@code true} if the item exists, otherwise {@code false}.
     */
    public boolean checkItem(String itemID) {
        return itemsMeta.containsKey(itemID);
    }

    /**
     * Increases the quantity of an existing item in the list.
     * 
     * @param itemID The unique identifier of the item.
     * @return The id, name, price, VAT and description of the added item
     *         as a string.
     */
    public String increaseQuantity(String itemID) {
        int quantity = getItemQuantity(itemID);
        if (quantity != 0) {
            itemsQuantity.put(itemID, ++quantity);
            return GetAddedItemPrintOut(getItem(itemID));
        }
        return "An error ocurred. Could not add item.";
    }

    /**
     * Retrieves the quantity of an item based on its item ID.
     * 
     * @param itemID The unique identifier of the item.
     * @return The quantity of the item, or 0 if the item does not exist.
     */
    private int getItemQuantity(String itemID) {
        return itemsQuantity.getOrDefault(itemID, 0);
    }

    /**
     * Adds a new item to the list with an initial quantity of 1 before
     * returning a printout of the added item information.
     * 
     * @param item The {@link ItemDTO} object representing the item to add.
     * @return The id, name, price, VAT and description of the added item
     *         as a string.
     */
    public String addNewItem(ItemDTO item) {
        itemsMeta.put(item.getID(), item);
        itemsQuantity.put(item.getID(), 1);
        return GetAddedItemPrintOut(item);
    }

    /**
     * Creates a printout of the details of an added or updated item.
     * 
     * @param item The {@link ItemDTO} object representing the item.
     * @return The id, name, price, VAT and description of the added item
     *         as a string.
     */
    private String GetAddedItemPrintOut(ItemDTO item) {
        return String.format("Added 1 item with ID %s:%n" +
                             "Item Name: %s%n" +
                             "Price: %.2f SEK%n" +
                             "VAT: %.0f%%%n" +
                             "Description: %s%n%n",
                             item.getID(), item.getName(), item.getPrice(), item.getVATRate() * 100, item.getDescription());
    }

    /**
     * Retrieves the metadata of an item based on its item ID.
     * 
     * @param itemID The unique identifier of the item.
     * @return The {@link ItemDTO} object representing the item, or {@code null} if
     *         not found.
     */
    public ItemDTO getItem(String itemID) {
        return itemsMeta.get(itemID);
    }

    /**
     * Creates a {@link BoughtItemsDTO} object containing all items and their
     * quantities.
     * 
     * @return A {@link BoughtItemsDTO} object representing the purchased items.
     */
    public BoughtItemsDTO getBoughtItemsDTO() {
        HashMap<ItemDTO, Integer> boughtItems = new HashMap<>();
        itemsMeta.forEach((itemID, itemDTO) -> {
            boughtItems.put(itemDTO, getItemQuantity(itemID));
        });
        return new BoughtItemsDTO(boughtItems);
    }
}