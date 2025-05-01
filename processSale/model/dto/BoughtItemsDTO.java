package processSale.model.dto;

import processSale.model.ItemList;

/**
 * might be an unnecessary dto class
 */
public class BoughtItemsDTO {
    private ItemList boughtItems;

    /**
     * 
     */
    public BoughtItemsDTO(ItemList boughtItemsList){
        boughtItems = boughtItemsList;
    }

    public ItemList getBoughtItems() {
        return boughtItems;
    }
}
