package processSale.integration;

import java.util.HashMap;
import processSale.model.dto.*;

/**
 * 
 */
class Receipt {
    private String timeOfSale;
    private SaleSummaryDTO saleSummary;

    /**
     * 
     * @param timeOfSale
     */
    public Receipt(TimeOfSaleDTO timeOfSale) {
        this.timeOfSale = timeOfSale.getTimeStamp();
    }

    /**
     * 
     * @param saleSummary
     */
    public void printReceipt(SaleSummaryDTO saleSummary) {
        this.saleSummary = saleSummary;
        HashMap<ItemDTO, Integer> boughtItems = saleSummary.getBoughtItems();
        StringBuilder items = new StringBuilder();
        boughtItems.forEach((itemDTO, quantity) -> {
            items.append(itemDTO.getName()).append(" ").append(quantity).append(" x ")
                    .append(itemDTO.getPrice()).append(" ").append(quantity * itemDTO.getPrice())
                    .append(" SEK\n");
        });

        System.out.println("------------------ Begin receipt -------------------\n" +
                           "Time of Sale: " + timeOfSale + "\n" +
                           "\n" +
                           items.toString() +
                           "\n" +
                           "Total: " + Math.round(saleSummary.getTotalPrice() * 100) / 100 + " SEK\n" +
                           "VAT: " + saleSummary.getTotalVAT() + " SEK\n" +
                           "\n" +
                           "Cash: " + saleSummary.getAmountPaid() + " SEK\n" +
                           "Change: " + Math.round(saleSummary.getChange() * 100.0) / 100.0 + " SEK\n" +
                           "------------------ End receipt ---------------------\n");
    }
}
