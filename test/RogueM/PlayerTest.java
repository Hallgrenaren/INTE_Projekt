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
    }

}