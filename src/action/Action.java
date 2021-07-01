package action;

import battle.Battle;
import character.Character;
import range.RangePicker;

public abstract class Action {
    protected String name;
    protected ActionJudge judge;
    protected RangePicker rangePicker;
    public Action(){
        this.judge = null;
    }

    public String getName(){
        return this.name;
    }
    public ActionJudge getJudge(){
        return this.judge;
    }

    public boolean validate(Character character, Battle battle, char command){
        return this.judge.validateAction(character, battle, command);
    }
    public void update(){
        this.judge.update();
    }
    public abstract void perform(Character character, Battle battle, char command);
}
