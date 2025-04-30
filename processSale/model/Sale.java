package processSale.model;
import processSale.model.dto.*;

public class Sale {
    private TimeOfSaleDTO timeOfSale;

    public Sale(String date, String time){
        timeOfSale = new TimeOfSaleDTO(date, time);
    }

    public TimeOfSaleDTO getTimeOfSale(){
        return timeOfSale;
    }

    public boolean itemExists(String itemID){
        increaseItemQuantity();
        return true;
    }

    public void increaseItemQuantity(){

    }

    public void addItem(ItemDTO item){

    }
}