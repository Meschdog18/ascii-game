import java.util.Random;

//make abstract
public abstract class EntityController {
    protected Entity model;
    protected EntityView view;

    //positons entity wants to move, but needs to col detect first
    protected int toX;
    protected int toY;

    public EntityController(Entity model, EntityView view){
        this.model = model;
        this.view = view;
        view.update(model.getX(), model.getY(), model.character()); //intial view set
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
    public abstract void update();
    public abstract void onCollison(EntityController colPartner);

}
