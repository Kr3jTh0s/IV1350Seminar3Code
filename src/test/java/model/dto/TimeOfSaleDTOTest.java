package processSale.model.dto;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TimeOfSaleDTOTest {
    @Test
    void testTimeOfSaleDTO() {
        String testTimestamp = "2023-05-01_14:30";
        TimeOfSaleDTO timeOfSale = new TimeOfSaleDTO(testTimestamp);
        
        assertEquals(testTimestamp, timeOfSale.getTimeStamp());
    }
}