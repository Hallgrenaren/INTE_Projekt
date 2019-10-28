package RogueM;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.event.KeyEvent;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @BeforeEach
    public void setup() {
        Map.getInstance().resetMap();
    }

    @Test
    public void testNameValid() {
        Player p = new Player("Zhasam", "Warrior");
        assertEquals("Zhasam", p.getName());
    }

    @Test
    public void testNameNull() {
        Player p = new Player(null, "Warrior");
        assertEquals("Fail", p.getName());
    }

    @Test
    public void testNameEmpty() {
        Player p = new Player("", "Warrior");
        assertEquals("Fail", p.getName());
    }
    @Test
    public void testNameMaxLength() {
        Player p = new Player("123456789", "Warrior");
        assertEquals("123456789", p.getName());
    }

    @Test
    public void testTooLongName() {
        Player p = new Player("12345678910", "Warrior");
        assertEquals("Fail", p.getName());
    }

    @Test
    public void testPClassInValidValues() {
        Player p = new Player("Zhasam", "arg");
        assertEquals("Warrior", p.getPClass());

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

    @Test
    public void testPlayerMove(){
        Player p = new Player("Zhasam", "Warrior");
        Position pos = p.getPosition();
        pos.setX(5);
        pos.setY(5);
        int key = KeyEvent.VK_A;
        p.move(key);
        assertEquals(4, pos.getX());
    }

    @Test
    public void testPlayerMoveOOBLeft(){
        Player p = new Player("Zhasam", "Warrior");
        Position pos = p.getPosition();
        int key = KeyEvent.VK_A;
        p.move(key);
        assertEquals(0, pos.getX());
    }

    @Test
    public void testPlayerMoveOOBDown(){
        Player p = new Player("Zhasam", "Warrior");
        Position pos = p.getPosition();
        pos.setY(9);
        int key = KeyEvent.VK_S;
        p.move(key);
        assertEquals(9, pos.getY());
    }

    @Test
    public void testPlayerMoveOOBRight(){
        Player p = new Player("Zhasam", "Warrior");
        Position pos = p.getPosition();
        pos.setX(9);
        int key = KeyEvent.VK_D;
        p.move(key);
        assertEquals(9, pos.getX());
    }

    @Test
    public void testPlayerMoveOOBTop(){
        Player p = new Player("Zhasam", "Warrior");
        Position pos = p.getPosition();
        int key = KeyEvent.VK_W;
        p.move(key);
        assertEquals(0, pos.getY());
    }

    @Test
    public void testPlayerDie(){
        Player p = new Player("Zhasam", "Warrior");
        p.takeDamage(201);
        assertFalse(p.isAlive());
    }

    @Test
    public void testPlayerDie2(){
        Player p = new Player("Zhasam", "Warrior");
        p.takeDamage(200);
        assertFalse(p.isAlive());
    }

    @Test
    public void testPlayerAlive(){
        Player p = new Player("Zhasam", "Warrior");
        p.takeDamage(50);
        assertTrue(p.isAlive());
    }
    @Test
    void updatePosition(){
        Player player = new Player("Zhasam", "Warrior");
        Map.getInstance().setPlayer(player);
        Map.getInstance().getPlayer().move(KeyEvent.VK_D);
        Position p = new Position(1,0);
        assertEquals(Map.getInstance().getPlayer().getPosition(),p);
    }

}