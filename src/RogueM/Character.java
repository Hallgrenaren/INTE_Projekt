package RogueM;

import java.util.ArrayList;

public class Character {
    private String name;
    private int health;
    private int speed;
    private int damage;
    private ArrayList<Item> inventory = new ArrayList<Item>();



    public Character(String name) {
        this.name = name;
        this.health = 100;
        this.speed = 10;
    }


    public int getHealth() {
        return health;
    }

    public int getSpeed() {
        return speed;
    }

    public String getName() {
        return name;
    }

}
