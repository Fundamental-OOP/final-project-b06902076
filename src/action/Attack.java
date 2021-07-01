package action;

import java.util.*;
import map.Square;
import character.Character;

public class Attack {
    public void perform(ArrayList<Square> range, int damage){
        for(Square square:range){
            Character target = square.getCharacter();
            if(target != null){
                target.attacked(damage);
            }
        }
    }
}
