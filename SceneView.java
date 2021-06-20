import java.util.Arrays;
import java.util.ArrayList;

public class SceneView extends Layer{

    private ArrayList<EntityController> entityControllers;
    private World world;
    public SceneView(ViewBox vb){
        super(vb.getDimX(), vb.getDimY());
        layerPriority = 2;
        
    }
    public void update(ArrayList<EntityController> entityControllers, World world){
        this.entityControllers = entityControllers;
        this.world = world;
    }
    public void clearLayer(){
        for( int i = 0; i < layerBuffer.length; i++ ){
            Arrays.fill( layerBuffer[i], null );
        }
    }
    public void createLayer(){
        //merges entities and world
        clearLayer();
        statusMessages.clear();

        for(int row = 0; row < layerBuffer.length; row++){
            for(int col = 0; col < layerBuffer[row].length; col++){

                for(EntityController eC: entityControllers){
                    EntityView eV = eC.getView(); //optmizie, this gets called many times, also x,y arent set for init pos, also make x,y priv

                    if(eV.getPointOnLayer(row, col) != null && eV.isRenderable()){
                        layerBuffer[row][col] = eV.getCharacter();
                    }
                }
                if(layerBuffer[row][col] == null){
                    layerBuffer[row][col] = world.tile(row, col).toString();
                }
            }
        }
    }
  public void combineStatusMessages(){
    for(EntityController eC: entityControllers){
      EntityView eV = eC.getView();
      ArrayList<String> messages = eV.getStatusMessages();
      if(messages.size() > 0){
        statusMessages.addAll(messages);
      }
    }
  }
}
