package action;

import battle.Battle;
import character.Character;

public class OnlyOnceJudge implements ActionJudge{
    protected boolean used;
    public OnlyOnceJudge(){
        this.used = false;
    }
    public void update(){

    }
    public boolean validateAction(Character character, Battle battle, char command){
        if(this.used){
            System.out.println("This action has been used.");
            return false;
        }
        this.used = true;
        return true;
    }
}
