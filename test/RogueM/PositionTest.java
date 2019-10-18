package RogueM;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PositionTest {

    @Test
    void testValidPosition(){
        Position p = new Position(1,9);

        assert(p.getY()==9)&&p.getX()==1;
    }

    @Test
    void testPositionOverTen(){
        Position p = new Position(100,150);
        Position expected = new Position(10,10);

        assertEquals(p, expected);

    }

    @Test
    void testPositionUnderOne(){
        Position p = new Position(0,-10);
        Position expected = new Position(0,0);

        assertEquals(p, expected);

    }

}