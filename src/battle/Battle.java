package battle;

import character.Character;
import map.*;
import graphics.*;

public class Battle {
    private Character player1, player2;
    private Map map;
    private Graphics graphics;
    private int availableID;
    public Battle(Character player1, Character player2){
        this.availableID = 1;
        this.player1 = player1;
        this.player2 = player2;
        player1.joinBattle(this);
        player1.setID(this.getNextID());
        player2.joinBattle(this);
        player2.setID(this.getNextID());
        this.map = new Map(8,8);
        this.characterInit();
    }
    public void setGraphics(Graphics graphics){
        this.graphics = graphics;
    }
    private void characterInit(){
        this.player1.setPosition(this.map.getSquare(0,0));
        this.player2.setPosition(this.map.getSquare(7,7));
    }
    public void start(){
        System.out.println("Battle Start.");
        Character[] players = {player1, player2};
        int current = 0, result = 0;
        while(result == 0){
            graphics.render(this.map);
            Character player = players[current];
            this.characterAct(player);
            this.map.update();
            player.update();
            result = this.checkResult();
            current = 1 - current;
        }
        this.processResult(result);
    }
    private int characterAct(Character character){
        this.graphics.showMessage("Player " + character.getID() + "'s move");
        character.act();
        return 0;
    }
    public Map getMap(){
        return this.map;
    }
    public int getNextID(){
        this.availableID += 1;
        return this.availableID-1;
    }
    private void processResult(int result){
        switch(result){
            case 1:
                System.out.println("Player 1 wins");
                break;
            case 2:
                System.out.println("Player 2 wins");
                break;
            case 3:
                System.out.println("Draw");
                break;
        }
    }
    private int checkResult(){
        boolean p1Dead = this.player1.isDead();
        boolean p2Dead = this.player2.isDead();
        if (!p1Dead && !p2Dead){
            return 0;
        }
        if(p1Dead && p2Dead){
            return 3;
        }
        if(p1Dead){
            return 2;
        }
        if(p2Dead){
            return 1;
        }
        return 0;
    }
}
