package character;

import knight.Knight;
import slime.Slime;

public class CharacterFactory {
    public static Character makeCharacter(int index){
        switch(index){
            case 0:
                System.out.println("Knight");
                return new Knight(new CLIControl());
            case 1:
                System.out.println("Slime");
                return new Slime(new CLIControl());
            default:
                System.err.println("No character corresponding to this index");
                return null;
        }
    }
}
