package processSale.integration;

import org.junit.jupiter.api.Test;
import processSale.model.dto.SaleSummaryDTO;
import processSale.model.dto.TimeOfSaleDTO;
import static org.junit.jupiter.api.Assertions.*;

class PrinterTest {
    @Test
    void testPrinterCreation() {
        Printer printer = new Printer();
        assertNotNull(printer);
    }

    @Test
    void testCreateReceipt() {
        Printer printer = new Printer();
        TimeOfSaleDTO time = new TimeOfSaleDTO("2023-05-01_14:30");
        
        printer.createReceipt(time);
        // No direct way to verify this except that no exception is thrown
        assertDoesNotThrow(() -> printer.createReceipt(time));
    }

    @Test
    void testPrintReceipt() {
        Printer printer = new Printer();
        TimeOfSaleDTO time = new TimeOfSaleDTO("2023-05-01_14:30");
        SaleSummaryDTO summary = new SaleSummaryDTO(time, null, null);
        
        printer.createReceipt(time);
        assertDoesNotThrow(() -> printer.printReceipt(summary));
    }
}