package RogueM;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Map {

    private static Map map = new Map();

    private Player player;
    private HashMap<Position, Monster> monsterInPosition = new HashMap<>();
    private HashMap<Position, Set<Item>> itemsInPosition = new HashMap<>();

    public void resetMap(){
        monsterInPosition = new HashMap<>();
        itemsInPosition = new HashMap<>();
    }

    public void combat(Monster monster){
        while (monster.isAlive() && player.isAlive()){
            monster.takeDamage(player.getDamage());
            if(monster.isAlive()){
                player.takeDamage(monster.getDamage());
            }
        }
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
    public void setPlayer(Player player){
        this.player = player;
    }
    public Player getPlayer(){
        return player;
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

    public void updatePlayerPosition(Position position){
        player.getPosition().setX(position.getX());
        player.getPosition().setY(position.getY());
        if(getMonster(position) != null){
            combat(getMonster(position));
        }
    }









}
