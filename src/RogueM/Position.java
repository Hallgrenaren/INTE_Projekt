package RogueM;

import java.util.ArrayList;

public class Position {
    private int x;
    private int y;


    public Position(int x, int y) {
        if (x < 1)
            x = 1;
        else if (x > 10)
            x = 10;
        if (y < 1)
            y = 1;
        else if (y > 10)
            y = 10;
        this.x = x;
        this.y = y;

    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public int hashCode() {
        return (int) (x * 1000 + y);
    }
    @Override
    public String toString() {
        return "[" + x + "," + y + "]";
    }
    @Override
    public boolean equals(Object o) {
        if(o instanceof Position) {
            Position p = (Position) o;
            return x == p.x && y == p.y;
        }
        else
            return false;
    }

}
