package processSale.integration;
import processSale.model.dto.*;

/**
 * 
 */
public class Printer {
    private Receipt currentReceipt;

    /**
     * 
     */
    public Printer(){
        System.out.println("Printer");
    }

    /**
     * 
     */
    public void createReceipt(TimeOfSaleDTO timeOfSale){
        currentReceipt = new Receipt(timeOfSale);
    }

    /**
     * 
     */
    public void printReceipt(SaleSummaryDTO saleSummaryDTO){
        System.out.println(currentReceipt.getReceipt());
    }
}
