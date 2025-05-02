package processSale.model.dto;

import java.util.HashMap;

/**
 * might be an unnecessary dto class
 */
public class BoughtItemsDTO {
    private HashMap<ItemDTO, Integer> boughtItems;

    /**
     * 
     * @param boughtItemsList
     */
    public BoughtItemsDTO(HashMap<ItemDTO, Integer> boughtItemsList) {
        boughtItems = boughtItemsList;
    }

    /**
     * 
     * @return
     */
    public HashMap<ItemDTO, Integer> getBoughtItems() {
        return boughtItems;
    }
}
