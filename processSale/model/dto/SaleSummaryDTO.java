package processSale.model.dto;

import java.util.HashMap;

/**
 * 
 */
public class SaleSummaryDTO {
    private TimeOfSaleDTO timeOfSale;
    private BoughtItemsDTO boughtItems;
    private PaymentInfoDTO paymentInfo;

    /**
     * 
     * @param timeOfSale
     * @param boughtItems
     * @param paymentInfo
     */
    public SaleSummaryDTO(TimeOfSaleDTO timeOfSale, BoughtItemsDTO boughtItems, PaymentInfoDTO paymentInfo) {
        this.timeOfSale = timeOfSale;
        this.boughtItems = boughtItems;
        this.paymentInfo = paymentInfo;
    }

    /**
     * 
     * @return
     */
    public String getTimeOfSale() {
        return timeOfSale.getTimeStamp();
    }

    /**
     * 
     * @return
     */
    public HashMap<ItemDTO, Integer> getBoughtItems() {
        return boughtItems.getBoughtItems();
    }

    /**
     * 
     * @return
     */
    public double getAmountPaid() {
        return paymentInfo.getAmountPaid();
    }

    /**
     * 
     * @return
     */
    public double getChange() {
        return paymentInfo.getChangeToGiveBack();
    }

    /**
     * 
     * @return
     */
    public double getTotalPrice() {
        return paymentInfo.getTotalPrice();
    }

    /**
     * 
     * @return
     */
    public double getTotalVAT() {
        return paymentInfo.getTotalVAT();
    }
}
