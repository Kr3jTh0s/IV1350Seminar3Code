package processSale.model.dto;

import org.junit.jupiter.api.Test;
import java.util.HashMap;
import static org.junit.jupiter.api.Assertions.*;

class SaleSummaryDTOTest {
    @Test
    void testSaleSummaryDTO() {
        TimeOfSaleDTO time = new TimeOfSaleDTO("2023-05-01_14:30");
        ItemDTO item = new ItemDTO("Apple", "001", "Fresh red apple", 10.0, 0.12);
        HashMap<ItemDTO, Integer> items = new HashMap<>();
        items.put(item, 2);
        BoughtItemsDTO boughtItems = new BoughtItemsDTO(items);
        PaymentInfoDTO paymentInfo = new PaymentInfoDTO(25.0, 5.0, 20.0, 2.4);
        
        SaleSummaryDTO summary = new SaleSummaryDTO(time, boughtItems, paymentInfo);
        
        assertEquals("2023-05-01_14:30", summary.getTimeOfSale());
        assertEquals(1, summary.getBoughtItems().size());
        assertEquals(25.0, summary.getAmountPaid());
        assertEquals(5.0, summary.getChange());
        assertEquals(20.0, summary.getTotalPrice());
        assertEquals(2.4, summary.getTotalVAT());
    }
}