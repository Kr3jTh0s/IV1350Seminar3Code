package processSale.model;
import processSale.model.dto.*;

/**
 * 
 */
public class Sale {
    private TimeOfSaleDTO timeOfSale;
    private ItemHandler items;
    private BoughtItemsDTO boughtItems;
    private SaleSummaryDTO saleSummary; //may not need to be here yet
    private double runningTotal;
    private double totalVAT;
    private double discount;

    /**
     * 
     */
    public Sale(String date, String time){
        timeOfSale = new TimeOfSaleDTO(date, time);
        items = new ItemHandler();
    }

    /**
     * 
     */
    public TimeOfSaleDTO getTimeOfSale(){
        return timeOfSale;
    }

    /**
     * 
     */
    public boolean itemExists(String itemID){
        return items.findItem(itemID);
    }

    /**
     * 
     */
    public void addItem(ItemDTO item){
        items.addItem(item);
    }
}