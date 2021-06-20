import java.util.Random;
import java.util.ArrayList;

//base class for all renderable interactable things in game
public abstract class EntityController {
    protected Entity model;
    protected EntityView view;

    //positons entity wants to move, but needs to col detect first
    protected int toX;
    protected int toY;
    
    protected boolean deactivated;

    protected ArrayList<EntityController> ecsBuffer;


    public EntityController(Entity model, EntityView view){
        this.model = model;
        this.view = view;
        view.update(model.getX(), model.getY(), model.character()); //intial view set
        toX = model.getX();
        toY = model.getY();
        view.createLayer();

    }
    
    public void setEcsBuffer(ArrayList<EntityController> ecs){
      ecsBuffer = ecs;
    }
    public void setLocation(int x, int y){
      //sets new location request if in bounds of the map,else just resets back to current positon
        if(view.inBounds(x, y)){
          model.setX(x);
          model.setY(y);
        
          view.update(x, y, model.character());
          view.createLayer();
        }else{
          toX = model.getX();
          toY = model.getY();
        }
    }
    public int getXBuffer(){return toX;}
    public int getYBuffer(){return toY;}
    public boolean isDeactivated(){return deactivated;}
    public ArrayList<EntityController> getEcsBuffer(){return ecsBuffer;}
    public Entity getModel(){return model;}
    public EntityView getView(){return view;}
    public abstract void update();
    public abstract void onCollison(EntityController colPartner);

}
