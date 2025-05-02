package processSale.view;

import org.junit.jupiter.api.Test;
import processSale.controller.Controller;
import processSale.integration.*;
import static org.junit.jupiter.api.Assertions.*;

class ViewTest {
    @Test
    void testViewCreation() {
        Printer printer = new Printer();
        Inventory inventory = new Inventory();
        Discount discount = new Discount();
        Account account = new Account();
        Controller controller = new Controller(printer, inventory, discount, account);
        
        View view = new View(controller);
        assertNotNull(view);
    }

    // Note: The View class contains mostly UI logic and Scanner interactions
    // which are typically not unit tested. The TestView inner class contains
    // the actual testable logic.
    
    @Test
    void testTestViewInputValidation() {
        TestView testView = new TestView(null, null);
        
        // Test input validation
        assertTrue(testView.checkPaymentInputs("10.0"));
        assertTrue(testView.checkPaymentInputs("15"));
        assertFalse(testView.checkPaymentInputs("abc"));
        assertFalse(testView.checkPaymentInputs(""));
    }
}