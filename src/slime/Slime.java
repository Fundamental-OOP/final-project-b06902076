package slime;

import character.Character;
import character.PlayerControl;
import action.*;

public class Slime extends Character{
    private SlimePiece[] pieces;
    private boolean isSplit;
    public Slime(PlayerControl control){
        super(control);
        this.isSplit = false;
        this.inputHandler = new InputHandler();
        this.pieces = new SlimePiece[2];
    }
    public void initActions(){
        this.actions[0] = new Move();
        this.actions[1] = new Lunge();
        //this.actions[2] = new Split();
    }
    public void split(){
        this.isSplit = true;
        this.pieces[0] = new SlimePiece(this.playerID, this.control);
        this.pieces[0] = new SlimePiece(this.playerID, this.control);
    }
    @Override
    public boolean isDead(){
        if(this.isSplit){
            if(this.pieces[0].isDead() && this.pieces[1].isDead()){
                return true;
            }
        }else{
            if(super.isDead()){
                return true;
            }
        }
        return false;
    }
    @Override
    public void act(){
        if(this.isSplit){
            for(SlimePiece piece : this.pieces){
                piece.act();
            }
        }else{
            super.act();
        }
    }
    public boolean hasSplit(){
        return this.isSplit;
    }

}
