package processSale.controller;
import processSale.integration.*;
import processSale.view.*;
import processSale.model.*;
import processSale.model.dto.*;

public class Controller {
    private Printer printer;
    private Inventory inv;
    private Discount disc;
    private Account acc;
    private Sale currentSale;

    public Controller(Printer printer, Inventory inv, Discount disc, Account acc){
        this.printer = printer;
        this.inv = inv;
        this.disc = disc;
        this.acc = acc;
    }

    public void startSale(String date, String time){

    }

}
