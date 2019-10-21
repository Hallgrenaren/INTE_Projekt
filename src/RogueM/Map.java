package RogueM;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Map {

    private static Map map = new Map();

    private HashMap<Position, Monster> monsterInPosition = new HashMap<>();
    private HashMap<Position, Set<Item>> itemsInPosition = new HashMap<>();

    public void resetMap(){
        monsterInPosition = new HashMap<>();
        itemsInPosition = new HashMap<>();
    }

    public void addItem(Position position, Item item){
        Set<Item> items = itemsInPosition.get(position);
        if (itemsInPosition.get(position) == null) {
            items = new HashSet<>();
            itemsInPosition.put(position, items);
        }
        items.add(item);
        itemsInPosition.put(position,items);
    }

    public void removeItem(Position position, Item item){
        if(itemsInPosition.containsKey(position)) {
            Set<Item> items = itemsInPosition.get(position);
            items.remove(item);
            itemsInPosition.put(position, items);

        }
    }

    public void addMonster(Position position, Monster monster){
        if(monsterInPosition.isEmpty())
        monsterInPosition.put(position, monster);
    }

    public void removeMonster(Position position){
        if(monsterInPosition.containsKey(position))
            monsterInPosition.remove(position);

    }

    public static Map getInstance(){
        return map;
    }

    public Monster getMonster(Position position){
        return monsterInPosition.get(position);
    }

    public Set<Item> getItems(Position position){
        Set<Item> items = itemsInPosition.get(position);

        return items;
    }



}
