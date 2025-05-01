package processSale.model.dto;

/**
 * The DTO class representing the time of a sale.
 * It contains the date and time of the sale as strings.
 */
public class TimeOfSaleDTO {
    private String date;
    private String time;

    /**
     * Creates a new instance representing the time of a sale.
     * 
     * @param date The date of the sale.
     * @param time The time of the sale.
     */
    public TimeOfSaleDTO(String date, String time) {
        this.date = date;
        this.time = time;
    }

    /**
     * Returns the date of the sale.
     * 
     * @return The date of the sale as a string.
     */
    public String getDate() {
        return date;
    }

    /**
     * Returns the time of the sale.
     * 
     * @return The time of the sale as a string.
     */
    public String getTime() {
        return time;
    }
}
