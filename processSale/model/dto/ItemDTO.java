package processSale.model.dto;

/**
 * This class represents a Data Transfer Object (DTO) for an item.
 * It contains information about the item's name, ID, description, price, and
 * VAT rate.
 */
public class ItemDTO {
    private String name;
    private String ID;
    private String description;
    private double price;
    private double VATRate;

    /**
     * Creates a new instance of ItemDTO with the specified attributes.
     * 
     * @param name        The name of the item.
     * @param ID          The unique identifier of the item.
     * @param description A brief description of the item.
     * @param price       The price of the item.
     * @param VATRate     The VAT rate applicable to the item.
     */
    public ItemDTO(String name, String ID, String description, double price, double VATRate) {
        this.name = name;
        this.ID = ID;
        this.description = description;
        this.price = price;
        this.VATRate = VATRate;
    }

    /**
     * Gets the name of the item.
     * 
     * @return The name of the item as a string.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the unique identifier of the item.
     * 
     * @return The ID of the item as a string.
     */
    public String getID() {
        return ID;
    }

    /**
     * Gets the description of the item.
     * 
     * @return The description of the item as a string.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Gets the price of the item.
     * 
     * @return The price of the item as a double.
     */
    public double getPrice() {
        return price;
    }

    /**
     * Gets the VAT rate applicable to the item.
     * 
     * @return The VAT rate of the item as a double.
     */
    public double getVATRate() {
        return VATRate;
    }
}