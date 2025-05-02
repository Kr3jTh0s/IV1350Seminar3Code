package src.main.java.processSale.model;

/**
 * Handles the processing of a payment, including calculating the change to give
 * back.
 */
class ProcessPayment {
    private final double changeToGiveBack; // The amount of change to return to the customer

    /**
     * Creates a new instance of ProcessPayment and calculates the change to give
     * back.
     * 
     * @param amountPaid The amount paid by the customer.
     * @param totalPrice The total price of the sale.
     */
    public ProcessPayment(double amountPaid, double totalPrice) {
        this.changeToGiveBack = calculateChange(amountPaid, totalPrice);
    }

    /**
     * Calculates the change to give back to the customer.
     * 
     * @param amountPaid The amount paid by the customer.
     * @param totalPrice The total price of the sale.
     * @return The calculated change.
     */
    private double calculateChange(double amountPaid, double totalPrice) {
        return (amountPaid - totalPrice);
    }

    /**
     * Retrieves the calculated change to give back to the customer.
     * 
     * @return The change amount.
     */
    public double getChange() {
        return changeToGiveBack;
    }
}
