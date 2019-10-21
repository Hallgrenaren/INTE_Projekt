package RogueM;

public class Item {
    private String name;
    private int health=0;
    private int speed=0;
    private int damage=0;

    public Item(String name, int health, int speed, int damage){
        try{
            if (name.equals("")){
                System.err.println("Empty name.");
                this.name = "Magic Stone";
            } else if (name.length() > 10) {
                System.err.println("Name too long");
                this.name = "Magic Stone";
            } else {
                this.name = name;
            }
        } catch (NullPointerException e){
            System.err.println("Not a name.");
            this.name = "Magic Stone"; //Lägg möjligen till kod för att användaren ska försöka igen
        }
        this.health = validItemValue(health);
        this.speed = validItemValue(speed);
        this.damage = validItemValue(damage);
    }

    private int validItemValue(int x){
        if(x < 0)
            x = 0;
        if(x > 5)
            x = 5;
        return x;
    }

    public int getHealth(){
      return health;
    }
    public int getSpeed(){
        return speed;
    }
    public int getDamage(){
        return damage;
    }

    public String getName() {
        return name;
    }
}
