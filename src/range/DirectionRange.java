package range;

import action.MoveJudge;
import character.Character;
import map.Square;
import map.Map;
import java.util.*;

public class DirectionRange implements RangePicker{
    public static int getDirection(Character character){
        System.out.println("Choose direction:");
        System.out.println("[d]: right, [s]: bottom, [a]: left, [w]: top");
        int direction = MoveJudge.decideDirection(character.getInput());
        return direction;
    }
    public ArrayList<Square> pickRange(Character character, Map map){
        ArrayList<Square> ret = new ArrayList<Square>();
        int direction = this.getDirection(character);
        if(map.getDestination(character.getPosition(), direction)!= null){
            ret.add(map.getDestination(character.getPosition(), direction));
        }
        return ret;
    }
}
