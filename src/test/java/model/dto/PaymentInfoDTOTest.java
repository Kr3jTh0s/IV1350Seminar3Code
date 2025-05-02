package processSale.model.dto;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PaymentInfoDTOTest {
    @Test
    void testPaymentInfoDTO() {
        PaymentInfoDTO paymentInfo = new PaymentInfoDTO(100.0, 20.0, 80.0, 10.0);
        
        assertEquals(100.0, paymentInfo.getAmountPaid());
        assertEquals(20.0, paymentInfo.getChangeToGiveBack());
        assertEquals(80.0, paymentInfo.getTotalPrice());
        assertEquals(10.0, paymentInfo.getTotalVAT());
    }
}