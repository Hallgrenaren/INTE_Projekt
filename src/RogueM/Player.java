package RogueM;

public class Player extends Character{
    String pClass;

    public Player(String name, int health, int speed, int damage, Position pos, String pClass){
        super(name, 150, speed, damage, pos);
        this.pClass = pClass;
    }

    public void die(){
        //GAME OVER
    }

    /*private void setClassVariables(){
        if(pClass.equals("Warrior")) {
            int hp = getHealth();
            hp += 50;
        }
    }*/

}
