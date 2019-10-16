package RogueM;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    public void testNameValidValues() {
        Player p = new Player("Zhasam", "Warrior");
        assertEquals("Zhasam", p.getName());
    }

    @Test
    public void testPClassFunctionValidValues() {
        Player p = new Player("Zhasam", "Warrior");
        assertEquals(50, p.getDamage());
        assertEquals(200, p.getHealth());
        assertEquals(10, p.getSpeed());
    }

    @Test
    public void testPClassFunctionValidValues2() {
        Player p = new Player("Zhasam", "Assassin");
        assertEquals(100, p.getDamage());
        assertEquals(100, p.getHealth());
        assertEquals(15, p.getSpeed());
    }

}