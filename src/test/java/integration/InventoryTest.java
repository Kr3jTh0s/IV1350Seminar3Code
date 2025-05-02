package processSale.integration;

import org.junit.jupiter.api.Test;
import processSale.model.dto.ItemDTO;
import static org.junit.jupiter.api.Assertions.*;

class InventoryTest {
    @Test
    void testInventoryCreation() {
        Inventory inventory = new Inventory();
        assertNotNull(inventory);
    }

    @Test
    void testGetItem() {
        Inventory inventory = new Inventory();
        
        // Test valid item
        ItemDTO item = inventory.getItem("1");
        assertNotNull(item);
        assertEquals("1", item.getID());
        
        // Test invalid item
        assertNull(inventory.getItem("999"));
    }

    @Test
    void testUpdateInventory() {
        Inventory inventory = new Inventory();
        TimeOfSaleDTO time = new TimeOfSaleDTO("2023-05-01_14:30");
        SaleSummaryDTO summary = new SaleSummaryDTO(time, null, null);
        
        // Just verify no exception is thrown
        assertDoesNotThrow(() -> inventory.updateInventory(summary));
    }
}