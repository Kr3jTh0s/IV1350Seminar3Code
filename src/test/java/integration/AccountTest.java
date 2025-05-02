package processSale.integration;

import org.junit.jupiter.api.Test;
import processSale.model.dto.SaleSummaryDTO;
import processSale.model.dto.TimeOfSaleDTO;
import static org.junit.jupiter.api.Assertions.*;

class AccountTest {
    @Test
    void testAccountCreation() {
        Account account = new Account();
        assertNotNull(account);
    }

    @Test
    void testAccountSale() {
        Account account = new Account();
        TimeOfSaleDTO time = new TimeOfSaleDTO("2023-05-01_14:30");
        SaleSummaryDTO summary = new SaleSummaryDTO(time, null, null);
        
        // Just verify no exception is thrown
        assertDoesNotThrow(() -> account.accountSale(summary));
    }
}