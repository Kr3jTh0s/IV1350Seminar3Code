package processSale.integration;
import processSale.model.dto.*;

public class Inventory {
    public Inventory(){
        System.out.println("Inventory");
    }

    public ItemDTO getItem(String itemID){
        return new ItemDTO();
    }
}
