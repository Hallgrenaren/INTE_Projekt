package RogueM;

public class Item {
    private String name;
    private int health=0;
    private int speed=0;
    private int damage=0;

    public Item(String name, int health, int speed, int damage){
        this.name=name;
        this.health=health;
        this.speed=speed;
        this.damage=damage;
    }

    public void drop(Position pos){
        //Add to map at position pos
    }
}
