package RogueM;

import java.util.ArrayList;

public class Monster {
    private String name;
    private int health;
    private int damage;
    public Position position;
    public ArrayList<Item> inventory = new ArrayList<Item>();

    public Monster(String name, int health, int damage, Position pos) {
        this.name = name;
        this.health = health;
        this.damage = damage;
        this.position = pos;
    }

    public void takeDamage(int damage){
        this.health -= damage;
        if(health<=0){
            die();
        }
    }

    public void addItem(Item item){
        inventory.add(item);
    }
    public void die(){
        //Remove from monster list

        for(Item item : inventory){  //Drop items
        item.drop(this.position);
        }

        //Gone from map?
    }

    public int getHealth() {
        return health;
    }

    public String getName() {
        return name;
    }

    public int getDamage() {
        return damage;
    }

    public Position getPosition(){
        return position;
    }

}
