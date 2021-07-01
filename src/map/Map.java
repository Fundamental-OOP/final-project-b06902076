package map;

public class Map {
    public final int width,height;
    private Square[][] squares;
    public Map(int width, int height){
        this.width = width;
        this.height = height;
        this.squares = new Square[height][width];
        for(int i = 0; i < height; i++){
            for(int j = 0; j < width; j++){
                this.squares[i][j] = new Square(j, i);
            }
        }
    }
    public Square getSquare(int i, int j){
        if( i < 0 || j < 0){
            return null;
        }
        else if( i >= this.height || j >= this.width){
            return null;
        }
        else {
            return this.squares[i][j];
        }
    }
    public int[] getSquareIndices(Square origin){
        for(int i=0;i<this.height;i++){
            for(int j=0;j<this.width;j++){
                if(this.squares[i][j] == origin){
                    int[] ret = { i, j };
                    return ret;
                }
            }
        }
        return null;
    }
    public Square getDestination(Square origin, int direction){
        final int[] dx = {1,0,-1,0};
        final int[] dy = {0,1,0,-1};
        int[] pos = this.getSquareIndices(origin);
        return this.getSquare(pos[0]+dy[direction], pos[1]+dx[direction]);
    }
    public void update(){
        for(Square[] row : this.squares){
            for(Square square : row){
                square.update();
            }
        }
    }
}
