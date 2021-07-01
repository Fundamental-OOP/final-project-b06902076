package range;

import character.Character;
import map.Map;
import map.Square;
import range.RangePicker;

import java.util.ArrayList;

public class SwordAttackRange extends DirectionRange {
    public ArrayList<Square> getSideRange(Square origin, Map map, int direction){
        ArrayList<Square> ret = new ArrayList<>();
        if(direction % 2 == 0){
            if(map.getDestination(origin, 1) != null){
                ret.add(map.getDestination(origin, 1));
            }
            if(map.getDestination(origin, 3) != null){
                ret.add(map.getDestination(origin, 3));
            }
        }else{
            if(map.getDestination(origin, 0) != null){
                ret.add(map.getDestination(origin, 0));
            }
            if(map.getDestination(origin, 2) != null){
                ret.add(map.getDestination(origin, 2));
            }
        }
        return ret;
    }
    public ArrayList<Square> pickRange(Character character, Map map){
        int direction = this.getDirection(character);
        ArrayList<Square> ret = new ArrayList<>();
        Square dest = map.getDestination(character.getPosition(), direction);
        if(dest != null){
            ret.add(dest);
            ArrayList<Square> sides = getSideRange(dest, map, direction);
            ret.addAll(sides);
        }
        return ret;
    }
}
