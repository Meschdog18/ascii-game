//world model class
public class World {
    private Tile map[][];
    private int width;
    private int height;

    public int height(){return height;}
    public int width(){return width;}

    public World(Tile[][] map){
        this.map = map;
        this.height = map.length;
        this.width = map[0].length;
    }

    public Tile tile(int x, int y){
        if(inBounds(x, y)){
            return map[x][y];
        }
        else{
            return Tile.WALL;
        }
    }
    public boolean inBounds(int x, int y){
        if(x<0 || x>= map.length || y < 0 || y >= map[x].length){
            return false;
        }

        return true;
    }
    public Tile[][] getMap(){return map;}
}
