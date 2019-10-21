package RogueM;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Map {

    private HashMap<Position, Monster> monsterInPosition = new HashMap<Position, Monster>();
    private HashMap<Position, Set<Item>> itemsInPosition = new HashMap<Position, Set<Item>>();

    public void addItem(Position position, Item item){
        Set<Item> items = itemsInPosition.get(position);
        if (itemsInPosition.get(position) == null) {
            items = new HashSet<Item>();
            itemsInPosition.put(position, items);
        }
        items.add(item);
        itemsInPosition.put(position,items);
        

    }



    public void addMonster(Position position, Monster monster){
        monsterInPosition.put(position, monster);
    }

    //returns null if no monster on the given position.
    public Monster getMonster(Position position){
        return monsterInPosition.get(position);
    }

    public HashMap<Position, Set<Item>> getItems(){
        HashMap<Position, Set<Item>> items = new HashMap<Position, Set<Item>>(itemsInPosition);

        return items;
    }


}
