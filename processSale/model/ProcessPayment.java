package processSale.model;

/**
 * 
 */
class ProcessPayment {
    private double changeToGiveBack;

    /**
     * 
     * @param amountPaid
     * @param totalPrice
     */
    public ProcessPayment(double amountPaid, double totalPrice) {
        changeToGiveBack = calculateChange(amountPaid, totalPrice);
    }

    /**
     * 
     * @param amountPaid
     * @param totalPrice
     * @return
     */
    private double calculateChange(double amountPaid, double totalPrice) {
        return (amountPaid - totalPrice);
    }

    /**
     * 
     * @return
     */
    public double getChange() {
        return changeToGiveBack;
    }
}
