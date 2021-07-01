package range;

import character.Character;
import map.Square;
import map.Map;
import java.util.*;

public interface RangePicker {
    ArrayList<Square> pickRange(Character character, Map map);
}
