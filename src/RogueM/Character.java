package RogueM;
import java.util.ArrayList;
abstract class Character {
    private String name;
    private int health;
    private int speed;
    private int damage;
    private Position position;
    private ArrayList<Item> inventory = new ArrayList<Item>();

    public Character(String name, int health, int speed, int damage, int xPos, int yPos) {
        this.name = name;
        this.health = health;
        this.speed = speed;
        this.damage = damage;
    }

    public void takeDamage(int damage){
        this.health -= damage;
        if(health<=0){
            if(this instanceof Monster){
                ((Monster) this).die();
            }else {
                ((Player)this).die();
            }
        }
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
