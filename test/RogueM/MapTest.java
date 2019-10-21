package RogueM;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class MapTest {

    @Test
    public void testAddMonster(){
        Map map = new Map();
        Monster monster = new Monster("Goblin", 100, 1, new Position(5,5));

        map.addMonster(monster.getPosition(), monster);

        assertEquals(map.getMonster(monster.getPosition()).getName(),"Goblin" );

    }

    @Test
    public void testAddItems(){
        Map map = new Map();
        Position pos = new Position(1,1);
        Item item1 = new Item("Sword",0,1,1);
        Item item2 = new Item("Shield",10,0,0);
        HashMap<Position, Set<Item>> expected = new HashMap<>();
        HashSet<Item> items = new HashSet<>();
        items.add(item1);
        items.add(item2);
        expected.put(pos,items);
        System.out.println(expected);

        map.addItem(pos,item1);
        map.addItem(pos,item2);
        System.out.println(map.getItems());
        assertEquals(map.getItems(), expected);


    }

    @Test
    public void testGetMonsterNotExists(){
        Map map = new Map();
        Monster m = map.getMonster(new Position(0,0));
        assert(m==null);
    }

}