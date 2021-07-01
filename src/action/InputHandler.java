package action;

public class InputHandler {
    public int handleInput(char input){
        int index;
        switch(input){
            case 'w':
            case 'a':
            case 's':
            case 'd':
                index = 0;
                break;
            case '1':
                index = 1;
                break;
            case '2':
                index = 2;
                break;
            case '3':
                index = 3;
                break;
            default:
                return -1;
        }
        return index;
    }
}
