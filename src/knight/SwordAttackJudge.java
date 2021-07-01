package knight;

import action.*;
import battle.Battle;
import character.Character;

public class SwordAttackJudge implements ActionJudge{
    public void update(){

    }
    public boolean validateAction(Character character, Battle battle, char command){
        return true;
    }
}
