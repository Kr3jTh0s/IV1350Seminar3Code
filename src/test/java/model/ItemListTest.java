package processSale.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import processSale.model.dto.ItemDTO;
import static org.junit.jupiter.api.Assertions.*;

class ItemListTest {
    private ItemList itemList;
    private ItemDTO testItem;

    @BeforeEach
    void setUp() {
        itemList = new ItemList();
        testItem = new ItemDTO("Apple", "001", "Fresh red apple", 10.0, 0.12);
    }

    @Test
    void testAddNewItem() {
        itemList.addNewItem(testItem);
        assertTrue(itemList.checkItem("001"));
        assertEquals(1, itemList.getBoughtItemsDTO().getBoughtItems().get(testItem));
    }

    @Test
    void testIncreaseQuantity() {
        itemList.addNewItem(testItem);
        itemList.increaseQuantity("001");
        assertEquals(2, itemList.getBoughtItemsDTO().getBoughtItems().get(testItem));
    }

    @Test
    void testCheckItem() {
        assertFalse(itemList.checkItem("001"));
        itemList.addNewItem(testItem);
        assertTrue(itemList.checkItem("001"));
        assertFalse(itemList.checkItem("999"));
    }

    @Test
    void testGetItem() {
        itemList.addNewItem(testItem);
        ItemDTO retrievedItem = itemList.getItem("001");
        assertEquals(testItem, retrievedItem);
        assertNull(itemList.getItem("999"));
    }

    @Test
    void testGetBoughtItemsDTO() {
        itemList.addNewItem(testItem);
        assertEquals(1, itemList.getBoughtItemsDTO().getBoughtItems().size());
        assertTrue(itemList.getBoughtItemsDTO().getBoughtItems().containsKey(testItem));
    }
}