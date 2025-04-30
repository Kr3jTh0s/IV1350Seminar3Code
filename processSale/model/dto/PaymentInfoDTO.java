package processSale.model.dto;

/**
 * 
 */
public class PaymentInfoDTO {
    private double amountPaid;
    private double changeToGiveBack;

    /**
     * 
     */
    public PaymentInfoDTO(double amountPaid, double change){
        this.amountPaid = amountPaid;
        changeToGiveBack = change;
    }

    /**
     * 
     */
    public double getAmountPaid() {
        return amountPaid;
    }
    
    /**
     * 
     */
    public double getChangeToGiveBack() {
        return changeToGiveBack;
    }
}
