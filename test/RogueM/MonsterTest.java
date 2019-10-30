package RogueM;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MonsterTest {

    @BeforeEach
    public void setup() {
        Karta.getInstance().resetMap();
    }

    @Test
    public void testConstructorValidName() {
        Monster p = new Monster("Zombie", 100,10, new Position(0,0));
        assertEquals("Zombie", p.getName());
    }

    @Test
    public void testConstructorValidHealth() {
        Monster p = new Monster("Zombie", 100,10, new Position(0,0));
        assertEquals(100, p.getHealth());
    }

    @Test
    public void testConstructorValidDamage() {
        Monster p = new Monster("Zombie", 100,10, new Position(0,0));
        assertEquals(10, p.getDamage());
    }

    @Test
    public void testConstructorValidPosition() {
        Monster p = new Monster("Zombie", 100,10, new Position(1,1));
        assert(p.getPosition().getX()==1&&p.getPosition().getY()==1);
    }

    @Test
    public void testConstructorInvalidPositionX1() {
        Monster p = new Monster("Zombie", 100,10, new Position(0,1));
        assert(p.getPosition().getX()==0&&p.getPosition().getY()==1);
    }

    @Test
    public void testConstructorInvalidPositionX2() {
        Monster p = new Monster("Zombie", 100,10, new Position(12,1));
        assert(p.getPosition().getX()==9&&p.getPosition().getY()==1);
    }

    @Test
    public void testConstructorInvalidPositionY1() {
        Monster p = new Monster("Zombie", 100,10, new Position(1,0));
        assert(p.getPosition().getX()==1&&p.getPosition().getY()==0);
    }

    @Test
    public void testConstructorInvalidPositionY2() {
        Monster p = new Monster("Zombie", 100,10, new Position(1,14));
        assert(p.getPosition().getX()==1&&p.getPosition().getY()==9);
    }

    @Test
    public void testMonsterTakeDamage(){
        Monster p = new Monster("Zombie", 100,10, new Position(0,0));
        p.takeDamage(50);
        assert(p.getHealth()==50);
    }

    @Test
    public void testMonsterExactKill(){
        Monster p = new Monster("Zombie", 100,10, new Position(0,0));
        p.takeDamage(100);
        assert(p.getHealth()==0); //how do we know the monster is dead??
    }

    @Test
    public void testMonsterOverkill(){
        Monster p = new Monster("Zombie", 100,10, new Position(0,0));
        p.takeDamage(150);
        assert(p.getHealth()==-50);//how do we know the monster is dead??
    }

    @Test
    public void testMonsterAddItem(){
        Monster p = new Monster("Zombie", 100,10, new Position(0,0));
        p.addItem(new Item("Axe",0,50,0));
        assert(!p.getInventory().isEmpty());
    }

    @Test
    public void testMonsterEqualsSameObject(){
        Monster p = new Monster("Zombie", 100, 10, new Position(0,0));
        assert(p.equals(p));
    }
    @Test
    public void testMonsterEqualsDifferentObject(){
        Monster p = new Monster("Zombie", 100, 10, new Position(0,0));
        Monster c = new Monster("Zombie", 100, 10, new Position(0,0));
        assert(p.equals(c));
    }
    @Test
    public void testMonsterNotEqualsPosition(){
        Monster p = new Monster("Zombie", 100, 10, new Position(0,0));
        Monster c = new Monster("Zombie", 100, 10, new Position(4,0));
        assert(!p.equals(c));
    }
    @Test
    public void testMonsterNotEqualsDamage(){
        Monster p = new Monster("Zombie", 100, 10, new Position(0,0));
        Monster c = new Monster("Zombie", 100, 100, new Position(0,0));
        assert(!p.equals(c));
    }
    @Test
    public void testMonsterNotEqualsHealth(){
        Monster p = new Monster("Zombie", 100, 10, new Position(0,0));
        Monster c = new Monster("Zombie", 200, 10, new Position(0,0));
        assert(!p.equals(c));
    }
    @Test
    public void testMonsterNotEqualsName(){
        Monster p = new Monster("Zombie", 100, 10, new Position(0,0));
        Monster c = new Monster("Orc", 100, 10, new Position(0,0));
        assert(!p.equals(c));
    }
    @Test
    public void testMonsterNotEqualsDifferentClass(){
        Monster p = new Monster("Zombie", 100, 10, new Position(0,0));
        Player c = new Player("Tyrone","Warrior");
        assert(!p.equals(c));
    }
    @Test
    public void testMonsterHashCodeStaysTheSame(){
        Monster p = new Monster("Zombie", 100, 10, new Position(0,0));
        int originalHash = p.hashCode();
        p.addItem(new Item("Sword",20,20,20));
        p.addItem(new Item("Chestguard of the whale",200,0,0));
        p.addItem(new Item("Pen",0,0,0));
        p.takeDamage(50);
        int newHash = p.hashCode();

        assertEquals(originalHash, newHash);
    }
    @Test
    public void testMonsterHashCodeSameOnTwoEqualObjects(){
        Monster p = new Monster("Zombie", 100, 10, new Position(0,0));
        Monster c = new Monster("Zombie", 100, 10, new Position(0,0));
        int pHashCode = p.hashCode();
        int cHashCode = c.hashCode();

        assertEquals(pHashCode,cHashCode);
    }

    @Test
    public void testMonsterDropItemsOnDeath(){
        Monster p = new Monster("Zombie", 100, 10, new Position(0,0));
        Karta.getInstance().addMonster(p.getPosition(),p);
        p.addItem(new Item("sword",1,1,1));
        p.addItem(new Item("helm", 2,2,2));
        p.takeDamage(103);
        assert(!Karta.getInstance().getItems(new Position(0,0)).isEmpty());
    }

    @Test
    public void testGetName(){
        Monster p = new Monster("Zombie", 100, 10, new Position(0,0));
        assert(p.getName().equals("Zombie"));
    }
    @Test
    public void testGetHealth(){
        Monster p = new Monster("Zombie", 100, 10, new Position(0,0));
        assert(p.getHealth()==100);
    }
    @Test
    public void testGetDamage(){
        Monster p = new Monster("Zombie", 100, 10, new Position(0,0));
        assert(p.getDamage()==10);
    }
    @Test
    public void testGetPosition(){
        Monster p = new Monster("Zombie", 100, 10, new Position(0,0));
        assert(p.getPosition().equals(new Position(0,0)));
    }

    @Test
    public void testNormalToEnraged(){
        Monster p = new Monster("Zombie", 100, 10, new Position(0,0));
        p.takeDamage(51);
        assertTrue(p.isEnraged());
    }

    @Test
    public void testNormalToScared(){
        Monster p = new Monster("Zombie", 100, 10, new Position(0,0));
        p.takeDamage(76);
        assertTrue(p.isScared());
    }

    @Test
    public void testNormalToScaredThroughEnraged(){
        Monster p = new Monster("Zombie", 100, 10, new Position(0,0));
        p.takeDamage(51);
        p.takeDamage(25);
        assert(p.isScared() && !p.isEnraged());
    }

    @Test
    public void testMonsterDieFromNormal(){
        Monster p = new Monster("Zombie", 100, 10, new Position(0,0));
        Karta.getInstance().addMonster(p.getPosition(),p);
        p.takeDamage(100);
        assert(Karta.getInstance().getMonster(new Position(0,0))==null); //if monster not in map its considered dead and gone from the map.
    }

    @Test
    public void testMonsterDieFromEnragedThroughNormal(){
        Monster p = new Monster("Zombie", 100, 10, new Position(0,0));
        Karta.getInstance().addMonster(p.getPosition(),p);
        p.takeDamage(55);
        p.takeDamage(100);
        assert(Karta.getInstance().getMonster(new Position(0,0))==null); //if monster not in map its considered dead and gone from the map.
    }

    @Test
    public void testMonsterDieFromScaredThroughNormal(){
        Monster p = new Monster("Zombie", 100, 10, new Position(0,0));
        Karta.getInstance().addMonster(p.getPosition(),p);
        p.takeDamage(76);
        p.takeDamage(100);
        assert(Karta.getInstance().getMonster(new Position(0,0))==null); //if monster not in map its considered dead and gone from the map.
    }

    @Test
    public void testMonsterDieFromScaredThroughNormalAndEnraged(){
        Monster p = new Monster("Zombie", 100, 10, new Position(0,0));
        Karta.getInstance().addMonster(p.getPosition(),p);
        p.takeDamage(55);
        p.takeDamage(21);
        p.takeDamage(100);
        assert(Karta.getInstance().getMonster(new Position(0,0))==null); //if monster not in map its considered dead and gone from the map.
    }

    @Test
    public void testMonsterNullValues(){
        Monster m = new Monster(null,-1,-1,null);
        Monster expected = new Monster("Monster",50,0,new Position(0,0));
        assertEquals(m, expected);
    }
    @Test
    public void testMonsterEqualsNull(){
        Monster monster = new Monster("Zombie", 100, 10, new Position(0,0));
        Monster monsternull = null;

        assert(!monster.equals(monsternull));
    }
}