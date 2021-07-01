package range;

import character.Character;
import map.Map;
import map.Square;

import java.util.ArrayList;

public class FrontTwoRange extends DirectionRange{
    public ArrayList<Square> pickRange(Character character, Map map){
        int direction = this.getDirection(character);
        ArrayList<Square> ret = new ArrayList<>();
        Square dest = map.getDestination(character.getPosition(), direction);
        if(dest != null){
            ret.add(dest);
            dest = map.getDestination(dest,direction);
            if(dest != null) {
                ret.add(dest);
            }
        }else{
            ret.add(null);
            ret.add(null);
        }
        return ret;
    }
}
