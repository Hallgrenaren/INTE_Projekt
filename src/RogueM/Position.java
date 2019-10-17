package RogueM;

import java.util.ArrayList;

public class Position {
    private int x;
    private int y;


    public Position(int x, int y) {
        if (x < 0)
            x = 0;
        else if (x > 9)
            x = 9;
        if (y < 0)
            y = 0;
        else if (y > 9)
            y = 9;
        this.x = x;
        this.y = y;

    }

    public int getX() {
        return x;
    }

    public void setX(int x) {this.x = x; }

    public int getY() {
        return y;
    }

    public void setY(int y) {this.y = y; }

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
