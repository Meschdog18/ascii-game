import java.util.Random;

//make abstract
public class EntityController {
    private Entity model;
    private EntityView view;

    //positons entity wants to move, but needs to col detect first
    private int toX;
    private int toY;

    public EntityController(Entity model, EntityView view){
        this.model = model;
        this.view = view;
        view.update(model.getX(), model.getY(), model.symbol()); //intial view set
    }
    
    public void update(){
        Random rand = new Random();

        toX = rand.nextInt(10);
        toY = rand.nextInt(5);
        
    }
    public void setLocation(int x, int y){

        model.setX(x);
        model.setY(y);
        
        view.update(x, y, model.character());
        view.createLayer();

    }
    public int getXBuffer(){return toX;}
    public int getYBuffer(){return toY;}
    public Entity getModel(){return model;}
    public EntityView getView(){return view;}
}
