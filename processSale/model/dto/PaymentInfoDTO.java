package processSale.model.dto;

/**
 * This class is a Data Transfer Object (DTO) that holds information about a
 * payment.
 * It contains the amount paid by the customer and the change to be given back.
 */
public class PaymentInfoDTO {
    private double amountPaid;
    private double changeToGiveBack;
    private double totalPrice;
    private double totalVAT;

    /**
     * Creates a new instance of PaymentInfoDTO with the specified amount paid and
     * change to give back.
     * 
     * @param amountPaid The total amount paid by the customer.
     * @param change     The change to be given back to the customer.
     */
    public PaymentInfoDTO(double amountPaid, double change, double runningTotal, double totalVAT) {
        this.amountPaid = amountPaid;
        changeToGiveBack = change;
        totalPrice = runningTotal;
        this.totalVAT = totalVAT;
    }

    /**
     * Gets the total amount paid by the customer.
     * 
     * @return Returns the total amount paid as a double.
     */
    public double getAmountPaid() {
        return amountPaid;
    }

    /**
     * Gets the change to be given back to the customer.
     * 
     * @return Returns the change to give back as a double.
     */
    public double getChangeToGiveBack() {
        return changeToGiveBack;
    }

    public double getTotalPrice() {
        return totalPrice;
    }
    
    public double getTotalVAT() {
        return totalVAT;
    }
}
