package processSale.model;

import java.util.HashMap;
import processSale.model.dto.BoughtItemsDTO;
import processSale.model.dto.ItemDTO;

/**
 * This class represents a list of items in a sale. It keeps track of the
 * quantity of each item and their metadata using two separate HashMaps.
 */
public class ItemList {
    private HashMap<String, Integer> itemsQuantity;
    private HashMap<String, ItemDTO> itemsMeta;

    /**
     * 
     */
    public ItemList() {
        itemsQuantity = new HashMap<String, Integer>();
        itemsMeta = new HashMap<String, ItemDTO>();
    }

    /**
     * 
     * @param itemID
     * @return
     */
    public boolean checkItem(String itemID) {
        return itemsMeta.containsKey(itemID);
    }

    /**
     * 
     * @param itemID
     */
    public void increaseQuantity(String itemID) {
        Integer count = getItemQuantity(itemID);
        itemsQuantity.put(itemID, ++count);

        // print
        printAddedItem(getItem(itemID));
    }

    /**
     * 
     * @param itemID
     * @return
     */
    private Integer getItemQuantity(String itemID) {
        return itemsQuantity.containsKey(itemID) ? itemsQuantity.get(itemID) : 0;
    }

    /**
     * 
     * @param itemID
     */
    public void addNewItem(ItemDTO item) {
        itemsMeta.put(item.getID(), item);
        itemsQuantity.put(item.getID(), 1);

        // print
        printAddedItem(item);
    }

    /**
     * 
     * @param item
     */
    private void printAddedItem(ItemDTO item) {
        System.out.println("Add 1 item with item id " + item.getID() + ":\n" +
                           "Item ID: " + item.getID() + "\n" +
                           "Item name: " + item.getName() + "\n" +
                           "Item cost: " + item.getPrice() + " SEK\n" +
                           "VAT: " + (item.getVATRate() * 100) + "%\n" +
                           "Item description: " + item.getDescription() + "\n");
    }

    /**
     * 
     * @param itemID
     * @return
     */
    public ItemDTO getItem(String itemID) {
        return itemsMeta.containsKey(itemID) ? itemsMeta.get(itemID) : null;
    }

    /**
     * 
     * @return
     */
    public BoughtItemsDTO getBoughtItemsDTO() {
        HashMap<ItemDTO, Integer> boughtItems = new HashMap<ItemDTO, Integer>();
        itemsMeta.forEach((itemID, itemDTO) -> {
            boughtItems.put(itemDTO, getItemQuantity(itemID));
        });
        return new BoughtItemsDTO(boughtItems);
    }
}