package character;

import java.util.*;

public class CLIControl implements PlayerControl{
    private Scanner in = new Scanner(System.in);
    @Override
    public char getInput() {
        char input = this.in.next().charAt(0);
        return input;
    }
}
