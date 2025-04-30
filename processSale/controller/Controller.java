package processSale.controller;
import processSale.integration.*;
import processSale.view.*;
import processSale.model.*;
import processSale.model.dto.*;

/**
 * 
 */
public class Controller {
    private View view;
    private Printer printer;
    private Inventory inv;
    private Discount disc;
    private Account acc;
    private Sale currentSale;

    /**
     * 
     */
    public Controller(Printer printer, Inventory inv, Discount disc, Account acc){
        this.printer = printer;
        this.inv = inv;
        this.disc = disc;
        this.acc = acc;
    }

    /**
     * 
     */
    public void setView(View view) {
        this.view = view;
    }

    /**
     * 
     */
    public void startSale(String date, String time){
        currentSale = new Sale(date, time);
        printer.createReceipt(currentSale.getTimeOfSale());
    }

    /**
     * 
     */
    public void registerItem(String itemID){
        if (!currentSale.itemExists(itemID)){
            currentSale.addItem(inv.getItem(itemID));
        }
    }

    /**
     * 
     */
    public void endSale(String customerID){

    }

    /**
     * 
     */
    public void processPayment(double amountPaid){

    }
}
