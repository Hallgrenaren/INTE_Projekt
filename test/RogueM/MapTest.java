package RogueM;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

class MapTest {

    @BeforeEach
    public void setup() {
        Map.getInstance().resetMap();
    }

    @Test
    public void testAddMonster(){

        Monster monster = new Monster("Goblin", 100, 1, new Position(5,5));

        Map.getInstance().addMonster(monster.getPosition(), monster);

        assertEquals("Goblin",Map.getInstance().getMonster(monster.getPosition()).getName());

    }

    @Test
    public void testAddItems(){
        Position pos = new Position(1,1);
        Item item1 = new Item("Sword",0,1,1);
        Item item2 = new Item("Shield",10,0,0);

        Map.getInstance().addItem(pos,item1);
        Map.getInstance().addItem(pos,item2);

        assertNotNull(Map.getInstance().getItems(pos));


    }

    @Test
    void testRemoveMonster(){
        Monster monster = new Monster("Goblin", 100, 1, new Position(5,5));
        Position position = new Position(4,4);

        Map.getInstance().addMonster(position, monster);
        Map.getInstance().removeMonster(position);

        assertNull(Map.getInstance().getMonster(position));

    }

    @Test
    void testRemoveItem(){
        Position pos = new Position(1,1);
        Item item1 = new Item("Sword",0,1,1);
        Item item2 = new Item("Shield",10,0,0);

        HashSet<Item> expected = new HashSet<>();
        expected.add(item2);

        Map.getInstance().addItem(pos,item1);
        Map.getInstance().addItem(pos,item2);

        Map.getInstance().removeItem(pos, item1);

        assertEquals(expected, Map.getInstance().getItems(pos));


    }

    @Test
     void monsterSamePosition(){
        Position pos = new Position(2,2);
        Monster m1 = new Monster("Orc",1,1,pos);
        Monster m2 = new Monster("Goblin",1,1,pos);

        Map.getInstance().addMonster(pos,m1);
        Map.getInstance().addMonster(pos,m2);

        assertEquals(m1,Map.getInstance().getMonster(pos));

    }

    @Test
    public void testGetMonsterNotExists(){
        Monster m = Map.getInstance().getMonster(new Position(0,0));
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

        Map.getInstance().addItem(pos,item1);
        Map.getInstance().addItem(pos,item2);

        assertEquals(expected,Map.getInstance().getItems(pos));




    }

    @Test
    void testMapGetItemsEmpty(){
        Position pos = new Position(1,1);

        assertNull(Map.getInstance().getItems(pos));

    }

    @Test
    public void testMapSetGetPlayer(){
        Player player = new Player("John", "Assassin");
        Map.getInstance().setPlayer(player);
        assert(player.equals(Map.getInstance().getPlayer()));
    }

    @Test
    public void testMapCombatOneShot(){
        Player player = new Player("John", "Assassin");
        Map.getInstance().setPlayer(player);
        Monster monster = new Monster("Zombie", 100, 10, new Position(0,0));
        Map.getInstance().combat(monster);
        assert(Map.getInstance().getPlayer().getHealth()==100);
    }
    @Test
    public void testMapCombatNotOneShotButWin(){
        Player player = new Player("John", "Assassin");
        Map.getInstance().setPlayer(player);
        Monster monster = new Monster("Zombie", 300, 10, new Position(0,0));
        Map.getInstance().combat(monster);
        assert(Map.getInstance().getPlayer().getHealth()==80);
    }
    @Test
    public void testMapCombatMonsterWin(){
        Player player = new Player("John", "Assassin");
        Map.getInstance().setPlayer(player);
        Monster monster = new Monster("Zombie", 300, 50, new Position(0,0));
        Map.getInstance().combat(monster);
        assert(!Map.getInstance().getPlayer().isAlive());
    }
    @Test
    public void testMapCombatMonsterRemovedOnDeath(){
        Player player = new Player("John", "Assassin");
        Map.getInstance().setPlayer(player);
        Monster monster = new Monster("Zombie", 300, 10, new Position(0,0));
        Map.getInstance().combat(monster);
        assert(Map.getInstance().getMonster(new Position(0,0))==null);
    }

}