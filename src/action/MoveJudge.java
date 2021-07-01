package action;

import battle.Battle;
import character.Character;
import map.*;

public class MoveJudge implements ActionJudge{
    private boolean canMove(Character character){
        return true;
    }
    public static int decideDirection(char command){
        int direction;
        switch(command){
            case 'w':
                direction = 3;
                break;
            case 'a':
                direction = 2;
                break;
            case 's':
                direction = 1;
                break;
            case 'd':
                direction = 0;
                break;
            default:
                System.err.println("Invoke Move with non-move command.");
                direction = -1;
                break;
        }
        return direction;
    }
    public void update(){

    }
    public boolean validateAction(Character character, Battle battle, char command){
        boolean movable = this.canMove(character);
        Square dest = battle.getMap().getDestination(character.getPosition(),decideDirection(command));
        if(dest == null){
            return false;
        }else{
            boolean notObstacle = !(dest instanceof Obstacle);
            return movable && notObstacle;
        }
    }
}
