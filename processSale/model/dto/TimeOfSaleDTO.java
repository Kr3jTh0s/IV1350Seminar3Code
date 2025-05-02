package processSale.model.dto;

/**
 * The DTO class representing the time of a sale.
 * It contains the date and time of the sale as strings.
 */
public class TimeOfSaleDTO {
    private String timeStamp;

    /**
     * Creates a new instance representing the time of a sale.
     * 
     * @param timeStamp The date and time of the sale.
     */
    public TimeOfSaleDTO(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    /**
     * Returns the date of the sale.
     * 
     * @return The date of the sale as a string.
     */
    public String getTimeStamp() {
        return timeStamp;
    }
}
