import utility.Color;

public class Entity {
    private int x;
    private int y;
    private char symbol;
    private Color color;


    public Entity(int x, int y){
        this.x = x;
        this.y = y;
        symbol = '@';
        color = Color.ANSI_PURPLE;
    }
    
    public void setX(int x){this.x=x;}
    public void setY(int y){this.y=y;}
    public int getX(){return x;}
    public int getY(){return y;}
    public String symbol(){return color.toString()+String.valueOf(symbol)+Color.ANSI_RESET.toString();}
    
}
