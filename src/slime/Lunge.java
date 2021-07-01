package slime;

import action.*;
import battle.Battle;
import character.Character;
import map.Square;
import range.FrontTwoRange;
import range.SwordAttackRange;
import java.util.*;

public class Lunge extends Action{
    public Lunge(){
        this.name="Lunge";
        this.judge = new LungeJudge();
        this.rangePicker = new FrontTwoRange();
    }
    public void perform(Character character, Battle battle, char command){
        ArrayList<Square> range = this.rangePicker.pickRange(character, battle.getMap());
        Square first = range.get(0);
        Square second = range.get(1);
        if(first != null && first.getCharacter() != null){
            first.getCharacter().attacked(1);
        }else if(second != null && second.getCharacter() != null){
            second.getCharacter().attacked(1);
            first.characterEnter(character);
        }else{
            if(second != null){
                second.characterEnter(character);
            }else if (first != null){
                first.characterEnter(character);
            }else{

            }
        }
    }
}
