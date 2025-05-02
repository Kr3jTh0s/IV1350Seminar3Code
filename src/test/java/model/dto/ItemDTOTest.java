package processSale.model.dto;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ItemDTOTest {
    @Test
    void testItemDTOCreation() {
        ItemDTO item = new ItemDTO("Apple", "001", "Fresh red apple", 10.0, 0.12);
        
        assertEquals("Apple", item.getName());
        assertEquals("001", item.getID());
        assertEquals("Fresh red apple", item.getDescription());
        assertEquals(10.0, item.getPrice());
        assertEquals(0.12, item.getVATRate());
    }

    @Test
    void testItemDTOGetters() {
        ItemDTO item = new ItemDTO("Banana", "002", "Yellow banana", 15.0, 0.06);
        
        assertAll("ItemDTO getters",
            () -> assertEquals("Banana", item.getName()),
            () -> assertEquals("002", item.getID()),
            () -> assertEquals("Yellow banana", item.getDescription()),
            () -> assertEquals(15.0, item.getPrice()),
            () -> assertEquals(0.06, item.getVATRate())
        );
    }
}