package processSale.integration;
import processSale.model.dto.*;

class Receipt {
    private TimeOfSaleDTO timeOfSale;

    public Receipt(TimeOfSaleDTO timeOfSale){
        this.timeOfSale = timeOfSale;
    }

    public String getReceipt(){
        return timeOfSale.getDate();
    }
}
