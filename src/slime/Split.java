package slime;

import action.*;
import battle.Battle;
import character.Character;

public class Split extends Action{
    public Split(){
        this.name = "Split";
        this.judge = new SplitJudge();
    }
    public void perform(Character character, Battle battle, char command){
        ((Slime)character).split();

    }
}
