package processSale.model;
import processSale.model.dto.*;

class ItemHandler {
    private ItemList firstItem;

    private class ItemList{
        private ItemDTO item;
        private Integer quantity;
        private ItemList nextItem;

        public ItemList(ItemDTO item, Integer quantity, ItemList next){
            this.item = item;
            this.quantity = quantity;
            this.nextItem = next;
        }

        public void increaseItemQuantity(){
            quantity++;
        }

        public ItemDTO getItem() {
            return item;
        }

        public Integer getQuantity() {
            return quantity;
        }
    }

    public ItemHandler(ItemDTO item){
        ItemList lastItem = null;
        lastItem = new ItemList(item, 1, lastItem);
        firstItem = lastItem;
    }

    public boolean findItem(String itemID){
        ItemList items = firstItem;
        while(items != null){
            if(items.getItem().)
        }
        return false;
    }

}
