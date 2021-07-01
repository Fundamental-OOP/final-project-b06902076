package graphics;

import character.Character;
import map.*;

public class CLIGraphics extends Graphics{
    private void printHP(Character character){
        System.out.print("    ");
        System.out.print(character.getHP());
        System.out.print("   ");
    }
    private void printCharacter(Character character){
        System.out.print("   P");
        System.out.print(character.getID());
        System.out.print("   ");
    }
    private void printSquareInfo(Square square){
        System.out.print("    ");
        System.out.print(" ");
        System.out.print("   ");
    }
    public void render(Map map){
        int width = map.width;
        int height = map.height;
        for(int y=0;y<height;y++){
            System.out.print("|");
            for(int x=0;x<width;x++) {
                System.out.print("--------|");
                if (x == width - 1) System.out.print("\n");
            }
            System.out.print("|");
            for(int x=0;x<width;x++){
                Character character = map.getSquare(y,x).getCharacter();
                if(character != null){
                    printHP(character);
                }else{
                    System.out.print("        ");
                }
                System.out.print("|");
                if(x == width-1)  System.out.print("\n");
            }
            System.out.print("|");
            for(int x=0;x<width;x++){
                Character character = map.getSquare(y,x).getCharacter();
                if(character != null){
                    printCharacter(character);
                }else{
                    System.out.print("        ");
                }
                System.out.print("|");
                if(x == width-1)  System.out.print("\n");
            }
            System.out.print("|");
            for(int x=0;x<width;x++){
                printSquareInfo(map.getSquare(y,x));
                System.out.print("|");
                if(x == width-1)  System.out.print("\n");
            }
        }
        System.out.print("|");
        for(int x=0;x<width;x++){
            System.out.print("--------|");
            if(x == width-1)  System.out.print("\n");
        }
    }
    public void showMessage(String msg){
        System.out.println(msg);
    }
}
