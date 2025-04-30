package processSale.model.dto;

public class TimeOfSaleDTO {
    private String date;
    private String time;

    public TimeOfSaleDTO(String date, String time){
        this.date = date;
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }
}
