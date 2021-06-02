import java.util.Arrays;
public class SceneView extends Layer{

    private EntityController[] entityControllers;
    private World world;

    public SceneView(int rowRange, int colRange){
        super(rowRange, colRange);
        layerPriority = 2;
        
    }
    public void update(EntityController[] entityControllers, World world){
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
        for(int row = 0; row < layerBuffer.length; row++){
            for(int col = 0; col < layerBuffer[row].length; col++){

                for(EntityController eC: entityControllers){
                    EntityView eV = eC.getView();
                    //sSystem.out.println(eV.getPointOnLayer(row, col));
                    if(eV.getPointOnLayer(row, col) != null){
                        layerBuffer[row][col] = eV.getCharacter();
                    }
                }
                if(layerBuffer[row][col] == null){
                    layerBuffer[row][col] = world.tile(row, col).toString();
                }
            }
        }
    }
}
