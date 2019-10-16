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

    @Test
    public void testPlayerTakeDamage(){
        Player p = new Player("Zhasam", "Warrior");
        p.takeDamage(50);
        assert(p.getHealth()==150);
    }

    @Test
    public void testPlayerTakeDamage2(){
        Player p = new Player("Zhasam", "Assassin");
        p.takeDamage(50);
        assert(p.getHealth()==50);
    }

    @Test
    public void testPlayerAddItem(){
        Player p = new Player("Zhasam", "Warrior");
        p.addItem(new Item("Axe",0,50,0));
        assert(!p.getInventory().isEmpty());
    }

}