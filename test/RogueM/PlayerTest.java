package RogueM;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    void testConstructorValidValues() {

        Player p = new Player("Steve");

        assertEquals("Steve", p.getName());
        assertEquals(100, p.getHealth());
        assertEquals(10, p.getSpeed());


    }


}