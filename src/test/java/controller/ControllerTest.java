package processSale.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import processSale.integration.*;
import static org.junit.jupiter.api.Assertions.*;

class ControllerTest {
    private Controller controller;
    private Printer printer;
    private Inventory inventory;
    private Discount discount;
    private Account account;

    @BeforeEach
    void setUp() {
        printer = new Printer();
        inventory = new Inventory();
        discount = new Discount();
        account = new Account();
        controller = new Controller(printer, inventory, discount, account);
    }

    @Test
    void testStartSale() {
        controller.startSale();
        // Verify by checking subsequent operations work
        assertDoesNotThrow(() -> controller.registerItem("1"));
    }

    @Test
    void testRegisterItem() {
        controller.startSale();
        
        // Test registering new item
        controller.registerItem("1");
        
        // Test increasing quantity of existing item
        controller.registerItem("1");
        
        // Test invalid item (shouldn't throw exception)
        assertDoesNotThrow(() -> controller.registerItem("999"));
    }

    @Test
    void testEndSale() {
        controller.startSale();
        controller.registerItem("1");
        assertDoesNotThrow(() -> controller.endSale("customer123"));
    }

    @Test
    void testProcessSale() {
        controller.startSale();
        controller.registerItem("1");
        controller.endSale("customer123");
        
        // Test with exact payment
        assertDoesNotThrow(() -> controller.processSale(10.0));
        
        // Test with overpayment
        assertDoesNotThrow(() -> controller.processSale(15.0));
    }
}