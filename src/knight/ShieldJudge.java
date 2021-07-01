package knight;

import action.ActionJudge;
import battle.Battle;
import character.Character;

public class ShieldJudge implements ActionJudge {
    public void update(){

    }
    public boolean validateAction(Character character, Battle battle, char command){
        return true;
    }
}
