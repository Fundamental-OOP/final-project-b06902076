package action;

import character.Character;
import battle.*;

public interface ActionJudge {
    void update();
    boolean validateAction(Character character, Battle battle, char command);
}
