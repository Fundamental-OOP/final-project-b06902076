package map;

import character.Character;

public class Obstacle extends Square{
    public Obstacle(int x, int y) {
        super(x, y);
    }
    public boolean characterEnter(Character character){
        return false;
    }
}
