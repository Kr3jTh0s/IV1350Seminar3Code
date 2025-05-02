package processSale.integration;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DiscountTest {
    @Test
    void testDiscountCreation() {
        Discount discount = new Discount();
        assertNotNull(discount);
    }

    @Test
    void testGetDiscount() {
        Discount discount = new Discount();
        assertEquals(1.0, discount.getDiscount("test123"));
        
        // Test with different customer IDs
        assertEquals(1.0, discount.getDiscount(""));
        assertEquals(1.0, discount.getDiscount(null));
    }
}