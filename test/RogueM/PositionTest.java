package RogueM;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PositionTest {

    @BeforeEach
    public void setup() {
        Map.getInstance().resetMap();
    }

    @Test
    void testValidPosition(){
        Position p = new Position(1,9);

        assert(p.getY()==9)&&p.getX()==1;
    }

    @Test
    void testPositionOverTen(){
        Position p = new Position(100,150);
        Position expected = new Position(10,10);

        assertEquals(expected,p);

    }

    @Test
    void testPositionUnderOne(){
        Position p = new Position(0,-10);
        Position expected = new Position(0,0);

        assertEquals(expected,p);

    }
    @Test
    void testNotEquals(){
        Position a = new Position(1,1);
        Position b = new Position(1,2);

        assertNotEquals(a,b);
    }
    @Test
    void testDifferentObjectEquals(){
        Position a = new Position(1,1);
        String b = "1,1";

        assert(!a.equals(b));
    }
    @Test
    void testToString(){
        Position p = new Position(1,1);

        assertEquals("[1,1]",p.toString());
    }





}