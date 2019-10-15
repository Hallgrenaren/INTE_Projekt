package RogueM;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Map {

    private HashMap<Position, Set<Monster>> monstersInPosition = new HashMap<>();
    private HashMap<Position, Set<Item>> itemsInPosition = new HashMap<>();

    public void addItem(Position position, Item item){
        Set<Item> items = itemsInPosition.get(position);
        if (itemsInPosition == null) {
            items = new HashSet<Item>();
            itemsInPosition.put(position, items);
        }
        items.add(item);
        itemsInPosition.put(position,items);

    }

    public void addMonster(Position position, Monster monster){
        Set<Monster> monsters = monstersInPosition.get(position);
        if (monstersInPosition == null) {
            monsters = new HashSet<Monster>();
            monstersInPosition.put(position, monsters);
        }
        monsters.add(monster);
        monstersInPosition.put(position,monsters);

    }


}
