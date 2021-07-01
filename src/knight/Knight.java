package knight;

import character.Character;
import character.PlayerControl;
import action.*;

public class Knight extends Character {
    private boolean isShielded;
    public Knight(PlayerControl control){
        super(control);
        this.inputHandler = new InputHandler();
        this.isShielded = false;
    }
    public void initActions(){
        this.actions[0] = new Move();
        this.actions[1] = new SwordAttack();
        this.actions[2] = new Shield();
    }
    public void activateShield(){
        this.isShielded = true;
    }
    @Override
    public void act(){
        if(this.isShielded){
            this.isShielded = false;
        }
        super.act();
    }
    @Override
    public void attacked(int damage){
        if(!this.isShielded){
            this.hpDecrease(damage);
        }
    }
}
