package processSale.model;

import java.util.HashMap;

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
     * @param item
     * @param quantity
     * @param next
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
        itemsQuantity.put(itemID, count++);
    }

    /**
     * 
     * @param itemID
     * @return
     */
    private Integer getItemQuantity(String itemID){
        return itemsQuantity.containsKey(itemID) ? itemsQuantity.get(itemID) : 0;
    }

    /**
     * 
     * @param itemID
     */
    public void addNewItem(ItemDTO item) {
        itemsMeta.put(item.getID(), item);
        itemsQuantity.put(item.getID(), 1);
    }

    public ItemDTO getItem(String itemID){
       return itemsMeta.containsKey(itemID) ? itemsMeta.get(itemID) : null;
    }
}