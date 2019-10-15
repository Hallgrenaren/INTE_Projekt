package RogueM;
import java.util.ArrayList;

public class Player {
    private String name;
    private int health;
    private int speed;
    private int damage;
    private Position position;
    private ArrayList<Item> inventory = new ArrayList<Item>();
    private String pClass;

    public Player(String name, int health, int speed, int damage, Position pos, String pClass){
        this.name = name;
        this.health = health;
        this.speed = speed;
        this.damage = damage;
        this.position = pos;
        this.pClass = pClass;
    }

    public void die(){
        //GAME OVER
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getHealth() {
        return health;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getSpeed() {
        return speed;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }

    public void setpClass(String pClass) {
        this.pClass = pClass;
    }

    public String getpClass() {
        return pClass;
    }

    /*private void setClassVariables(){
        if(pClass.equals("Warrior")) {
            int hp = getHealth();
            hp += 50;
        }
    }*/

}
