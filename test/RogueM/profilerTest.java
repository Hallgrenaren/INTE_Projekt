package RogueM;


import org.junit.jupiter.api.Test;

import java.awt.event.KeyEvent;

public class profilerTest {

    @Test
    public void testCombatExample(){

        new Player("Player1","Assassin");
        for(int i = 0; i<5; i++){
            new Monster("Monster", 110, 20, new Position(9-i,i+1));
        }

        for(int i = 0; i<5; i++){
            Karta.getInstance().getPlayer().move(KeyEvent.VK_S);
            Karta.getInstance().getPlayer().move(KeyEvent.VK_D);
        }
        assert(Karta.getInstance().getPlayer().getHealth()==80);
    }

}
