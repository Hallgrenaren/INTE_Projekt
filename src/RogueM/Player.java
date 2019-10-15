package RogueM;

public class Player extends Character{
    String pClass;

    public Player(String name, int health, int speed, int damage, int xPos, int yPos, String pClass){
        super(name, 150, speed, damage, xPos, yPos);
        this.pClass = pClass;
    }

    /*private void setClassVariables(){
        if(pClass.equals("Warrior")) {
            int hp = getHealth();
            hp += 50;
        }
    }*/

}
