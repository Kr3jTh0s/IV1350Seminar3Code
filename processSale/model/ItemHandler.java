package processSale.model;

import processSale.model.dto.*;

/**
 * Package private item handler class that manages a
 * list of items objects.
 */
class ItemHandler {
    private ItemList firstItem;

    /**
     * Private item list class creates nodes containing
     * item dto, item quantity and a pointer to next item
     * in the list.
     */
    private class ItemList {
        private ItemDTO item;
        private Integer quantity;
        private ItemList nextItem;

        /**
         * Default constructor for the ItemList class.
         * Initializes the item, quantity, and next item pointer
         * with the provided values.
         * 
         * @param item     The item DTO representing the item in the list.
         * @param quantity The quantity of the item in the list.
         * @param next     The next item list object in the linked list.
         */
        public ItemList(ItemDTO item, Integer quantity, ItemList next) {
            this.item = item;
            this.quantity = quantity;
            this.nextItem = next;
        }

        /**
         * Increases the quantity of the current item in the list by one.
         */
        public void increaseItemQuantity() {
            quantity++;
        }

        /**
         * Getter method for the item DTO in the list.
         * 
         * @return Returns the item DTO representing the item in the list.
         */
        public ItemDTO getItem() {
            return item;
        }

        /**
         * Getter method for the quantity of the item in the list.
         * 
         * @return Returns the quantity of the item in the list.
         */
        public Integer getQuantity() {
            return quantity;
        }

        /**
         * Getter method that retrieves the next item list
         * object referenced by the pointer.
         * 
         * @return Returns the next item list object represented
         *         by the pointer of this item.
         */
        public ItemList nextItem() {
            return nextItem;
        }
    }

    /**
     * Default constructor for the ItemHandler class.
     * Initializes the first item in the list as a null placeholder.
     */
    public ItemHandler() {
        firstItem = new ItemList(null, null, null);
    }

    /**
     * Searches for an item in the list by its ID and increases its quantity
     * if found. If the item is not found, it returns false.
     * 
     * @param itemID The ID of the item to search for.
     * @return Returns true if the item is found and its quantity is increased,
     *         otherwise returns false.
     */
    public boolean findItem(String itemID) {
        ItemList currentItem = firstItem;
        while (currentItem != null) {
            if (currentItem.getItem().getID().equals(itemID)) {
                currentItem.increaseItemQuantity(); // may need to be moved for cohesion
                return true;
            }
            currentItem = currentItem.nextItem();
        }
        return false;
    }

    /**
     * Adds a new item to the list. The new item is added at the beginning
     * of the list, and its quantity is set to 1.
     * 
     * @param item The item DTO representing the item to be added.
     */
    public void addItem(ItemDTO item) {
        ItemList newItem = new ItemList(item, 1, firstItem);
        firstItem = newItem;
    }

}
