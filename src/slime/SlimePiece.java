package slime;

import action.Move;
import character.Character;
import character.PlayerControl;

public class SlimePiece extends Slime{
    public SlimePiece(int id, PlayerControl control){
        super(control);
        this.hp = 1;
        this.playerID = id;
    }
    public void initActions(){
        this.actions[0] = new Move();
        this.actions[1] = new Lunge();
    }
}
