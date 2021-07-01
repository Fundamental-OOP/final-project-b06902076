package character;

import map.Square;
import java.lang.Math;
import action.*;
import battle.*;

public abstract class Character {
    protected Battle battle;
    protected int playerID;
    protected int hp;
    protected char command;
    protected Square position;
    protected Action[] actions;
    protected PlayerControl control;
    protected InputHandler inputHandler;
    public Character(){
    }
    public Character(PlayerControl control){
        this.hp = 3;
        this.control = control;
        this.actions = new Action[4];
        this.initActions();
    }
    public void setID(int id){
        this.playerID = id;
    }
    public void joinBattle(Battle battle){
        this.battle = battle;
    }
    public int getHP(){
        return this.hp;
    }
    public void setHP(int hp) {
        this.hp = hp;
    }
    public void hpDecrease(int damage){
        this.hp = Math.max(0, this.hp - damage);
    }
    public void hpIncrease(int regenerate){
        this.hp = Math.min(3, this.hp + regenerate);
    }
    public void setPosition(Square square) {
        this.position = square;
        square.setCharacter(this);
    }
    public void attacked(int damage){
        this.hp = Math.max(0, this.hp - damage);
    }
    public Square getPosition() {
        return this.position;
    }
    public int getID(){
        return this.playerID;
    }
    public char getInput(){
        return this.control.getInput();
    }
    private int chooseAction(){
        char key;
        int index;
        do{
            key = this.getInput();       // index of chosen action
            index = this.inputHandler.handleInput(key);
        }while(index == -1);
        this.command = key;
        return index;
    }
    public boolean isDead(){
        return this.hp == 0;
    }
    public void update(){
        for(Action action : this.actions){
            if(action != null){
                action.update();
            }
        }
    }
    public void act(){
        printActionMessage();
        int index;
        do{
            index = this.chooseAction();
        }while(!this.actions[index].validate(this, this.battle, this.command));
        this.actions[index].perform(this, this.battle, this.command);
    }
    private void printActionMessage(){
        for(int i=1;i<4;i++){
            if(this.actions[i] != null)
            {
                System.out.print("["+i+"] " + this.actions[i].getName() + " ");
            }
        }
        System.out.print("\n");
    }
    public abstract void initActions();
}
