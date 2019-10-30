package RogueM;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.Random;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class KartaTest {

    @BeforeEach
    public void setup() {
        Karta.getInstance().resetMap();
    }

    @Test
    public void testAddMonster(){

        Monster monster = new Monster("Goblin", 100, 1, new Position(5,5));

        Karta.getInstance().addMonster(monster.getPosition(), monster);

        assertEquals("Goblin", Karta.getInstance().getMonster(monster.getPosition()).getName());

    }

    @Test
    public void testAddItems(){
        Position pos = new Position(1,1);
        Item item1 = new Item("Sword",0,1,1);
        Item item2 = new Item("Shield",10,0,0);

        Karta.getInstance().addItem(pos,item1);
        Karta.getInstance().addItem(pos,item2);

        assertNotNull(Karta.getInstance().getItems(pos));


    }

    @Test
    void testRemoveMonster(){
        Monster monster = new Monster("Goblin", 100, 1, new Position(5,5));
        Position position = new Position(4,4);

        Karta.getInstance().addMonster(position, monster);
        Karta.getInstance().removeMonster(position);

        assertNull(Karta.getInstance().getMonster(position));

    }

    @Test
    void testRemoveItem(){
        Position pos = new Position(1,1);
        Item item1 = new Item("Sword",0,1,1);
        Item item2 = new Item("Shield",10,0,0);

        HashSet<Item> expected = new HashSet<>();
        expected.add(item2);

        Karta.getInstance().addItem(pos,item1);
        Karta.getInstance().addItem(pos,item2);

        Karta.getInstance().removeItem(pos, item1);

        assertEquals(expected, Karta.getInstance().getItems(pos));


    }

    @Test
     void monsterSamePosition(){
        Position pos = new Position(2,2);
        Monster m1 = new Monster("Orc",1,1,pos);
        Monster m2 = new Monster("Goblin",1,1,pos);

        Karta.getInstance().addMonster(pos,m1);
        Karta.getInstance().addMonster(pos,m2);

        assertEquals(m1, Karta.getInstance().getMonster(pos));

    }

    @Test
    public void testGetMonsterNotExists(){
        Monster m = Karta.getInstance().getMonster(new Position(0,0));
        assert(m==null);
    }
    @Test
    void testMapGetItemsInPosition(){
        Position pos = new Position(1,1);
        Item item1 = new Item("Sword",0,1,1);
        Item item2 = new Item("Shield",10,0,0);
        HashSet<Item> expected = new HashSet<>();
        expected.add(item1);
        expected.add(item2);

        Karta.getInstance().addItem(pos,item1);
        Karta.getInstance().addItem(pos,item2);

        assertEquals(expected, Karta.getInstance().getItems(pos));




    }

    @Test
    void testMapGetItemsEmpty(){
        Position pos = new Position(1,1);

        assertNull(Karta.getInstance().getItems(pos));

    }

    @Test
    public void testMapSetGetPlayer(){
        Player player = new Player("John", "Assassin");
        Karta.getInstance().setPlayer(player);
        assert(player.equals(Karta.getInstance().getPlayer()));
    }

    @Test
    public void testMapCombatOneShot(){
        Player player = new Player("John", "Assassin");
        Karta.getInstance().setPlayer(player);
        Monster monster = new Monster("Zombie", 100, 10, new Position(0,0));
        Karta.getInstance().combat(monster);
        assert(Karta.getInstance().getPlayer().getHealth()==100);
    }
    @Test
    public void testMapCombatNotOneShotButWin(){
        Player player = new Player("John", "Assassin");
        Karta.getInstance().setPlayer(player);
        Monster monster = new Monster("Zombie", 300, 10, new Position(0,0));
        Karta.getInstance().combat(monster);
        assert(Karta.getInstance().getPlayer().getHealth()==80);
    }
    @Test
    public void testMapCombatMonsterWin(){
        Player player = new Player("John", "Assassin");
        Karta.getInstance().setPlayer(player);
        Monster monster = new Monster("Zombie", 300, 50, new Position(0,0));
        Karta.getInstance().combat(monster);
        assert(!Karta.getInstance().getPlayer().isAlive());
    }
    @Test
    public void testMapCombatMonsterRemovedOnDeath(){
        Player player = new Player("John", "Assassin");
        Karta.getInstance().setPlayer(player);
        Monster monster = new Monster("Zombie", 300, 10, new Position(0,0));
        Karta.getInstance().combat(monster);
        assert(Karta.getInstance().getMonster(new Position(0,0))==null);
    }


}