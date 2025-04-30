package processSale.view;
import processSale.controller.*;

/**
 * 
 */
public class View {
    private Controller contr;

    /**
     * 
     */
    public View(Controller contr){
        this.contr = contr;
        contr.setView(this);
    }

    /**
     * 
     */
    public void awaitInputs(){
        System.out.println("yo");
    }

    /**
     * 
     */
    public void startSale(){
        contr.startSale("today", "now");
    }

}