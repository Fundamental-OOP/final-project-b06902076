package action;

import battle.Battle;
import character.Character;

public class CountDownJudge implements ActionJudge{
    private int countdown;
    private int currentCountDown;
    public CountDownJudge(int countdown){
        this.countdown = countdown;
        this.currentCountDown = 0;
    }
    public void update(){
        this.currentCountDown = Math.max(0, this.currentCountDown-1);
    }
    public boolean validateAction(Character character, Battle battle, char command){
        if(this.currentCountDown == 0){
            this.currentCountDown = this.countdown;
            return true;
        }else{
            System.out.println("This action is cooling down.");
            return false;
        }
    }
}
