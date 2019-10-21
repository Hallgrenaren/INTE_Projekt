package RogueM;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ItemTest {

    @Test
    public void itemValidValues(){
        Item t = new Item("axe", 0, 0, 0);
        assertEquals("axe", t.getName());
        assertEquals(0, t.getHealth());
        assertEquals(0, t.getSpeed());
        assertEquals(0, t.getDamage());
    }

    @Test
    public void itemInvalidBotHealth(){
        Item t = new Item("axe", -1, 0, 0);
        assertEquals(0, t.getHealth());
    }

    @Test
    public void itemInvalidBotSpeed(){
        Item t = new Item("axe", 0, -1, 0);
        assertEquals(0, t.getSpeed());
    }

    @Test
    public void itemInvalidBotDamage(){
        Item t = new Item("axe", 0, 0, -1);
        assertEquals(0, t.getDamage());
    }

    @Test
    public void itemInvalidTopHealth(){
        Item t = new Item("axe", 6, 0, 0);
        assertEquals(5, t.getHealth());
    }

    @Test
    public void itemInvalidTopSpeed(){
        Item t = new Item("axe", 0, 6, 0);
        assertEquals(5, t.getSpeed());
    }

    @Test
    public void itemInvalidTopDamage(){
        Item t = new Item("axe", 0, 0, 6);
        assertEquals(5, t.getDamage());
    }

    @Test
    public void notNull(){
        Item t = new Item(null, 0, 0, 0);
        assertEquals("Magic Stone", t.getName());
    }

    @Test
    public void testNameEmpty() {
        Item t = new Item("", 0, 0, 0);
        assertEquals("Magic Stone", t.getName());
    }

    @Test
    public void testNameTooLong() {
        Item t = new Item("12345678910", 0, 0, 0);
        assertEquals("Magic Stone", t.getName());
    }
}
