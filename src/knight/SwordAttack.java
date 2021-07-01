package knight;

import action.*;
import battle.Battle;
import character.Character;
import map.Square;
import range.SwordAttackRange;
import java.util.*;

public class SwordAttack extends Action{
    private Attack attack;
    public SwordAttack(){
        this.name="SwordAttack";
        this.judge = new SwordAttackJudge();

        this.rangePicker = new SwordAttackRange();
        this.attack = new Attack();
    }

    public void perform(Character character, Battle battle, char command){
        ArrayList<Square> range = this.rangePicker.pickRange(character, battle.getMap());
        this.attack.perform(range,1);
    }
}
