package RogueM;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class MapTest {

    @Test
    void testAddMonster(){
        Map map = new Map();
        Monster monster = new Monster("Goblin", 100, 1, new Position(5,5));

        map.addMonster(monster.getPosition(), monster);

        assertEquals(map.getMonster(monster.getPosition()).getName(),"Goblin" );

    }

    @Test
    void testAddItems(){
        Map map = new Map();
        Position pos = new Position(1,1);
        Item item1 = new Item("Sword",0,1,1);
        Item item2 = new Item("Shield",10,0,0);
        HashMap<Position, Set<Item>> expected = new HashMap<>();
        HashSet<Item> items = new HashSet<>();
        items.add(item1);
        items.add(item2);
        expected.put(pos,items);

        map.addItem(pos,item1);
        map.addItem(pos,item2);

        assertEquals(map.getItems(), expected);


    }

    @Test
    void testRemoveMonster(){
        Map map = new Map();
        Monster monster = new Monster("Goblin", 100, 1, new Position(5,5));
        Position position = new Position(4,4);

        map.addMonster(position, monster);
        map.removeMonster(position);

        assertNull(map.getMonster(position));

    }

    @Test
    void testRemoveItem(){
        Map map = new Map();
        Position pos = new Position(1,1);
        Item item1 = new Item("Sword",0,1,1);
        Item item2 = new Item("Shield",10,0,0);

        HashMap<Position, Set<Item>> expected = new HashMap<>();
        HashSet<Item> items = new HashSet<>();
        items.add(item2);
        expected.put(pos,items);

        map.addItem(pos,item1);
        map.addItem(pos,item2);

        map.removeItem(pos, item1);

        assertEquals(map.getItems(), expected);


    }

}