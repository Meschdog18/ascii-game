import utility.Color;

//base model class
public abstract class Entity {
    private int x;
    private int y;
    private String character;
    protected Color color;


    public Entity(int x, int y, String character){
        this.x = x;
        this.y = y;
        this.character = character;
        color = Color.ANSI_PURPLE;
    }
    public void setX(int x){this.x=x;}
    public void setY(int y){this.y=y;}
    public int getX(){return x;}
    public int getY(){return y;}
    public void setColor(Color color){
      this.color = color;
    }
    public void setCharacter(String character){this.character = character;}
    public String character(){return color.toString()+character+Color.ANSI_RESET.toString();}
}
