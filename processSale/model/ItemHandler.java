package processSale.model;
import processSale.model.dto.*;

/**
 * 
 */
class ItemHandler {
    private ItemList firstItem;

    /**
     * 
     */
    private class ItemList{
        private ItemDTO item;
        private Integer quantity;
        private ItemList nextItem;

        /**
         * 
         */
        public ItemList(ItemDTO item, Integer quantity, ItemList next){
            this.item = item;
            this.quantity = quantity;
            this.nextItem = next;
        }

        /**
         * 
         */
        public void increaseItemQuantity(){
            quantity++;
        }

        /**
         * 
         */
        public ItemDTO getItem() {
            return item;
        }

        /**
         * 
         */
        public Integer getQuantity() {
            return quantity;
        }

        /**
         * 
         */
        public ItemList nextItem(){
            return nextItem;
        }
    }

    /**
     * 
     */
    public ItemHandler(){
        ItemList lastItem = null;
        lastItem = new ItemList(null, null, lastItem);
        firstItem = lastItem;
    }

    /**
     * 
     */
    public boolean findItem(String itemID){
        ItemList currentItem = firstItem;
        while(currentItem != null){
            if(currentItem.getItem().getID().equals(itemID)){
                currentItem.increaseItemQuantity(); // may need to be moved for cohesion
                return true;
            }
            currentItem = currentItem.nextItem();
        }
        return false;
    }

    /**
     * 
     */
    public void addItem(ItemDTO item){
        ItemList newItem = new ItemList(item, 1, firstItem);
        firstItem = newItem;
    }

}
