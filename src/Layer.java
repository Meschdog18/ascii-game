import java.util.Random;
import java.util.Map;

public class Layer {
    private int rowRange;
    private int colRange;
    private String layerBuffer[][];

    private Entity[] entities;
    private Scene scene;
    public Layer(Scene scene){
        //default view box of 5x5
        rowRange = 12;
        colRange = 7;

        this.scene = scene;
        entities = this.scene.getEntities();
    }

    public void createLayer(){
        World world = scene.getWorld();
        //Tile[][] map = world.getMap();
        layerBuffer = new String[rowRange][colRange]; //5x5 view box
        

        
        //combines entities and map into 2d layer
        for(Entity entity : entities){
            
            layerBuffer [entity.getX()][entity.getY()] = String.valueOf(entity.character());

        }
        //first assign key points (entities)

    
        //then fill in rest with map
        for(int row = 0; row < layerBuffer.length; row++){
            for(int col = 0; col < layerBuffer[row].length; col++){

                if(layerBuffer[row][col] == null){
                    layerBuffer[row][col] = world.tile(row-1, col-1).toString();
                }
            }
        }
    }
    public String[][] getLayer(){
        return layerBuffer;
    }
}
