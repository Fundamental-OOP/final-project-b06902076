package action;

import battle.Battle;
import character.Character;
import map.*;

public class Move extends Action{
    public Move(){
        this.name = "Move";
        this.judge = new MoveJudge();
    }
    public void update(){

    }
    public void perform(Character character, Battle battle, char command){
        int direction = MoveJudge.decideDirection(command);
        Square dest = battle.getMap().getDestination(character.getPosition(), direction);
        if(dest.getCharacter() != null){
            character.hpDecrease(1);
        }else{
            dest.characterEnter(character);
        }
    }
}
