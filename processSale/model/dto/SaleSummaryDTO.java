package processSale.model.dto;

/**
 * 
 */
public class SaleSummaryDTO {
    private TimeOfSaleDTO timeOfSale;
    private BoughtItemsDTO boughtItems;
    private PaymentInfoDTO paymentInfo;

    /**
     * 
     */
    public SaleSummaryDTO(TimeOfSaleDTO timeOfSale, BoughtItemsDTO boughtItems, PaymentInfoDTO paymentInfo){
        this.timeOfSale = timeOfSale;
        this.boughtItems = boughtItems;
        this.paymentInfo = paymentInfo;
    }

    public double getChange() {
        return this.paymentInfo.getChangeToGiveBack();
    }

}
