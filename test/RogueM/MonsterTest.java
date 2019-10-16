package RogueM;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MonsterTest {

    @Test
    public void testConstructorValidName() {
        Monster p = new Monster("Zombie", 100,10,new Position(0,0));
        assertEquals("Zombie", p.getName());
    }

    @Test
    public void testConstructorValidHealth() {
        Monster p = new Monster("Zombie", 100,10,new Position(0,0));
        assertEquals(100, p.getHealth());
    }

    @Test
    public void testConstructorValidDamage() {
        Monster p = new Monster("Zombie", 100,10,new Position(0,0));
        assertEquals(10, p.getDamage());
    }

    @Test
    public void testConstructorValidPosition() {
        Monster p = new Monster("Zombie", 100,10,new Position(0,0));
        assert(p.getPosition().getX()==0&&p.getPosition().getY()==0);
    }

    @Test
    public void testMonsterTakeDamage(){
    Monster p = new Monster("Zombie", 100,10,new Position(0,0));
    p.takeDamage(50);
    assert(p.getHealth()==50);
    }

    @Test
    public void testMonsterExactKill(){
        Monster p = new Monster("Zombie", 100,10,new Position(0,0));
        p.takeDamage(100);
        assert(p.getHealth()==0);
    }

    @Test
    public void testMonsterOverkill(){
        Monster p = new Monster("Zombie", 100,10,new Position(0,0));
        p.takeDamage(150);
        assert(p.getHealth()==-50);
    }

    @Test
    public void testMonsterAddItem(){
        Monster p = new Monster("Zombie", 100,10,new Position(0,0));
        p.addItem(new Item("Axe",0,50,0));
        assert(!p.getInventory().isEmpty());
    }
    /*@Test
    public void testMonsterDie(){
        Monster p = new Monster(new Position(0,0));
        p.takeDamage(100);
        assert(!map.MonsterList.exists(p));
    }*/

    /*@Test
    public void testMonsterDropItemsOnDeath(){

    }*/

}