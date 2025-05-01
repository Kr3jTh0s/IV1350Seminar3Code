package processSale.model;

/**
 * 
 */
class ProcessPayment {
    private double changeToGiveBack;

    /**
     * 
     */
    public ProcessPayment(double amountPaid, double totalPrice){
        double changeToGiveBack = calculateChange(amountPaid, totalPrice);
    }

    private double calculateChange(double amountPaid, double totalPrice){
        return (amountPaid - totalPrice);
    }

    public double getChange() {
        return changeToGiveBack;
    }
}
