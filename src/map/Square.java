package map;

import character.Character;

import java.util.*;

public class Square {
    private int x,y;        // coordinate
    private Character character;
    public Square(int x, int y){
        this.x = x;
        this.y = y;
        this.character = null;
    }
    public boolean characterEnter(Character character){
        character.getPosition().characterLeave();
        character.setPosition(this);
        return true;
    }
    public boolean characterLeave(){
        this.character = null;
        return true;
    }
    public void setCharacter(Character character){
        this.character = character;
    }
    public Character getCharacter(){
        return this.character;
    }
    public void update(){
        if(this.character != null){
            if(character.isDead()){
                this.character = null;
            }
        }
    }
}
