package RogueM;

abstract class Character {
    private String name;
    private int health;
    private int speed;
    private int damage;
    private ArrayList<Item> inventory = new ArrayList<Item>();

    public Character(String name, int health, int speed, int damage) {
        this.name = name;
        this.health = health ;
        this.speed = speed;
        this.damage = damage;
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
