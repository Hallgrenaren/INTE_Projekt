package RogueM;

import java.util.ArrayList;

public class Position {
    private int x;
    private int y;


    public Position(int x, int y) {
        this.x = validPosCheck(x);
        this.y = validPosCheck(y);
    }

    public int validPosCheck(int a){
        if (a < 0)
            a = 0;
        else if (a > 9)
            a = 9;
        return a;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        x = validPosCheck(x);
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        y = validPosCheck(y);
        this.y = y;
    }

    @Override
    public int hashCode() {
        return (x * 1000 + y);
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
