import character.CharacterFactory;
import character.Character;
import battle.Battle;
import graphics.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        Character player1, player2;
        System.out.println("Choose the character of player 1:");
        System.out.println("[0] Knight, [1] Slime");
        player1 = CharacterFactory.makeCharacter(in.nextInt());
        System.out.println("Choose the character of player 2:");
        System.out.println("[0] Knight, [1] Slime");
        player2 = CharacterFactory.makeCharacter(in.nextInt());
        Battle battle = new Battle(player1, player2);
        battle.setGraphics(new CLIGraphics());
        battle.start();
    }
}
