package knight;

import action.*;
import battle.Battle;
import character.Character;
import map.Square;
import range.SwordAttackRange;

public class Shield extends Action{
    public Shield(){
        this.name="Shield";
        this.judge = new ShieldJudge();
    }
    public void perform(Character character, Battle battle, char command){
        Knight knight = (Knight) character;
        knight.activateShield();
    }
}
