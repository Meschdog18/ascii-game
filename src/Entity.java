import java.util.Random;
public class Entity {
    private int x;
    private int y;
    private char character;

    //positons entity wants to move, but needs to col detect first
    private int toX;
    private int toY;

    public Entity(int x, int y){
        this.x = x;
        this.y = y;
        character = '@';
    }
    public void update(){
        Random rand = new Random();

        toX = rand.nextInt(10)+1;
        toY = rand.nextInt(5)+1;
    }
    public void setLocation(int x, int y){
        this.x = x;
        this.y = y;
    }
    public int getX(){return x;}
    public int getY(){return y;}
    public int getToX(){return toX;}
    public int getToY(){return toY;}
    public char character(){return character;}

}
