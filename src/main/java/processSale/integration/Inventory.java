package src.main.java.processSale.integration;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import src.main.java.processSale.model.dto.*;

/**
 * Represents the inventory system that manages item data and updates inventory
 * after a sale. It loads item data from a file and provides methods to retrieve
 * and update inventory information.
 */
public class Inventory {
    private final File inventoryDatabase; // File containing inventory data
    private final ItemDTO[] items;        // Array to store items in the inventory

    /**
     * Initializes the inventory system by loading item data from a file.
     * The file must contain item data in the format: name ID description price
     * VATRate.
     */
    public Inventory() {
        inventoryDatabase = new File("acc.txt");
        items = new ItemDTO[6]; // Assuming a fixed size for simplicity

        try (Scanner myReader = new Scanner(inventoryDatabase)) {
            int rowNumber = 0;

            while (myReader.hasNextLine()) {
                String[] row = myReader.nextLine().split(" ");
                ItemDTO item = new ItemDTO(
                        row[0], // Name
                        row[1], // ID
                        row[2], // Description
                        Double.parseDouble(row[3]), // Price
                        Double.parseDouble(row[4]) // VAT Rate
                );
                items[rowNumber++] = item;
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: Inventory file not found.");
            e.printStackTrace();
        }

        System.out.println("Inventory system initialized.");
    }

    /**
     * Retrieves an item from the inventory based on its unique identifier.
     * 
     * @param itemID The unique identifier of the item.
     * @return The {@link ItemDTO} object if found, otherwise {@code null}.
     */
    public ItemDTO getItem(String itemID) {
        for (ItemDTO item : items) {
            if (item != null && item.getID().equalsIgnoreCase(itemID)) {
                return item;
            }
        }
        return null; // Item not found
    }

    /**
     * Updates the inventory after a sale.
     * 
     * @param saleSummaryDTO A {@link SaleSummaryDTO} containing details of the
     *                       completed sale.
     */
    public void updateInventory(SaleSummaryDTO saleSummaryDTO) {
        System.out.println("Inventory updated.");
    }
}
