package processSale.model.dto;

/**
 * 
 */
public class ItemDTO {
    private String name;
    private String ID;
    private String description;
    private double price;
    private double VATRate;
    
    /**
     * 
     */
    public ItemDTO(String name, String ID, String description, double price, double VATRate){
        this.name = name;
        this.ID = ID;
        this.description = description;
        this.price = price;
        this.VATRate = VATRate;
    }

    /**
     * 
     */
    public String getName() {
        return name;
    }

    /**
     * 
     */
    public String getID() {
        return ID;
    }

    /**
     * 
     */
    public String getDescription() {
        return description;
    }

    /**
     * 
     */
    public double getPrice() {
        return price;
    }

    /**
     * 
     */
    public double getVATRate() {
        return VATRate;
    }
}
