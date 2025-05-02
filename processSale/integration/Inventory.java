package processSale.integration;

import processSale.model.dto.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * 
 */
public class Inventory {

    private File inventoryDatabase;
    private Scanner myReader;
    private ItemDTO[] ext_items;

    /**
     * 
     */
    public Inventory() {
        try {
            inventoryDatabase = new File("acc.txt");
            myReader = new Scanner(inventoryDatabase);
            Integer rowNumber = 0;
            ext_items = new ItemDTO[6];

            while (myReader.hasNextLine()) {
                ItemDTO item;
                String row[] = myReader.nextLine().split(" ");
                item = new ItemDTO(row[0], row[1], row[2], Double.parseDouble(row[3]), Double.parseDouble(row[4]));

                ext_items[rowNumber++] = item;
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occured.");
            e.printStackTrace();
        }
        System.out.println("Inventory created");
    }

    /**
     * 
     * @param itemID
     * @return
     */
    public ItemDTO getItem(String itemID) {
        for (int i = 0; i < ext_items.length; i++) {
            if (ext_items[i].getID().equalsIgnoreCase(itemID)) {
                return ext_items[i];
            }
        }

        return null;
    }

    /**
     * 
     * @param saleSummaryDTO
     */
    public void updateInventory(SaleSummaryDTO saleSummaryDTO) {

    }
}
