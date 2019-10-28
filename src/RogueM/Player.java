package RogueM;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Player {
    private String name;
    private int health;
    private int speed;
    private int damage;
    Position position;
    private ArrayList<Item> inventory = new ArrayList<Item>();
    private String pClass;
    private boolean alive;

    public Player(String name, String pClass){
        try{
            if (name.equals("")){
                System.err.println("Empty name.");
                this.name = "Fail";
            } else if (name.length() > 10) {
                System.err.println("Name too long");
                this.name = "Fail";
            } else {
                this.name = name;
            }
        } catch (NullPointerException e){
                System.err.println("Not a name.");
                this.name = "Fail"; //Lägg möjligen till kod för att användaren ska försöka igen
            }

        if(!(pClass.equals("Warrior") || pClass.equals("Assassin"))) {
            System.err.println("Not a class, Default=Warrior");
            this.pClass = "Warrior";
        } else {
            this.pClass = pClass;
        }
        if(pClass.equals("Warrior")) {
            this.health = 200;
            this.speed = 10;
            this.damage = 50;
        }
        else if(pClass.equals("Assassin")) {
            this.health = 100;
            this.speed = 15;
            this.damage = 100;
        }
        this.position = new Position(0,0);
        this.alive = true;
    }

    public void die(){
        this.alive = false; //vore annan kod ifall vi hade ett implementerat gränssnitt, där skulle man få game-over screen o få starta om.
    }

    //tar en int som parameter som ska komma från en KeyEventHandlers KeyCode.
    public void move(int key){
        if (key == KeyEvent.VK_W){
            position.setY(position.getY() - 1);
        } else if (key == KeyEvent.VK_A){
            position.setX(position.getX() - 1);
        } else if (key == KeyEvent.VK_S){
            position.setY(position.getY() + 1);
        } else if (key == KeyEvent.VK_D) {
            position.setX(position.getX() + 1);
        }
        Map.getInstance().updatePlayerPosition(position);

    }



    public void takeDamage(int damage){
        this.health -= damage;
        if(health<=0){
            die();
        }
    }

    public void updateStatsFromItems(Item item){
        this.health += item.getHealth();
        this.damage += item.getDamage();
        this.speed += item.getSpeed();
    }

    public void addItem(Item item){
        inventory.add(item);
        updateStatsFromItems(item);
    }

    public String getName() {
        return name;
    }

    public List<Item> getInventory(){
        return inventory;
    }

    public int getHealth() {
        return health;
    }

    public int getSpeed() {
        return speed;
    }

    public int getDamage() {
        return damage;
    }

    public Position getPosition() {
        return position;
    }

    public String getPClass() {
        return pClass;
    }

    public boolean isAlive() {
        return alive;
    }
}
