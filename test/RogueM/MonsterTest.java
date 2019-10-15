package RogueM;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MonsterTest {

    @Test
    public void testConstructorValidValues() {
        Monster p = new Monster();
        assertEquals("Zombie", p.getName());
    }

    @Test
    public void testMonsterTakeDamage(){
    Monster p = new Monster();


    }

    //@Test
    //public void testMonsterDropItemsOnDeath(){

    //}

}