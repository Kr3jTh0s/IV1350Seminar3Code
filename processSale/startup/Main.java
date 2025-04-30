package processSale.startup;
import processSale.controller.Controller;
import processSale.integration.*;
import processSale.view.*;

public class Main{
    public static void main(String[] args){
        System.out.println("yo");

        Printer printer = new Printer();
        Inventory inv = new Inventory();
        Discount disc = new Discount();
        Account acc = new Account();

        Controller contr = new Controller(printer, inv, disc, acc);
        View view = new View(contr);

        view.awaitInputs();
    }
}