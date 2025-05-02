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
    public Printer() {
        System.out.println("Printer created");
    }

    /**
     * 
     * @param timeOfSale
     */
    public void createReceipt(TimeOfSaleDTO timeOfSale) {
        currentReceipt = new Receipt(timeOfSale);
    }

    /**
     * 
     * @param saleSummaryDTO
     */
    public void printReceipt(SaleSummaryDTO saleSummaryDTO) {
        currentReceipt.printReceipt(saleSummaryDTO);
    }
}
