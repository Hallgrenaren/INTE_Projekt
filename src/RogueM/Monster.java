package RogueM;

import java.util.ArrayList;
import java.util.List;

public class Monster implements Comparable<Monster> {
    private String name;
    private int health;
    private int damage;
    private Position position;
    private ArrayList<Item> inventory = new ArrayList<Item>();

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

    public List<Item> getInventory(){
        return inventory;
    }

    public void updateStatsFromItems(Item item){
        this.health += item.getHealth();
        this.damage += item.getDamage();
    }

    public void addItem(Item item){
        inventory.add(item);
        updateStatsFromItems(item);
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

    @Override
    public int hashCode(){
        return 31 * (name.hashCode() + getHealth() + getDamage() + getPosition().getY() + getPosition().getX());
    }

    @Override
    public boolean equals(Object o){
        if(o==this){
            return true;
        }
        if(!(o instanceof Monster)){
            return false;
        }
        Monster m = (Monster)o;
        return this.name == m.name && this.health == m.health && this.damage == m.damage && this.position.getX() == m.position.getX() && this.position.getY() == m.position.getY();
    }

    public int compareTo(Monster monster) {
        if(monster.position.getY()==this.position.getY()&&monster.position.getX()==this.position.getX())
            return 0;//same
        if((monster.position.getX()+monster.position.getY())>(this.position.getX()+this.position.getY()))
            return 1;//monster greater than this
        else
            return -1;
    }
}
