package processSale.integration;
import processSale.model.dto.*;

/**
 * 
 */
class Receipt {
    private String timeOfSale;

    /**
     * 
     */
    public Receipt(TimeOfSaleDTO timeOfSale){
        this.timeOfSale = timeOfSale.getTimeStamp();
    }

    /**
     * 
     */
    public String getReceipt(){
        return timeOfSale;
    }
}
