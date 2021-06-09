import java.util.Arrays;
import java.util.Map;
import java.util.ArrayList;


public class Scene {
    private World world;
    private ArrayList<EntityController> Entities;
    public Scene(){
        Entities = new ArrayList<EntityController>();
        for(int i =0; i<3;i++){
            //Entity entity = new Entity(i, 0);
            //EntityView view = new EntityView(10, 5);
            //new EntityController(entity, view)
            Character character = new Character(i,0, 100);
            CharacterView view = new CharacterView(10, 5);

            Entities.add(new CharacterController(character, view));
        }
        world = new World(generateMap(10, 5));
    }
    public Tile[][] generateMap(int height, int width){
        Tile[][] map = new Tile[height][width];

        for(int x=0;x<height;x++){
            for(int y=0;y<width;y++){
                map[x][y] = Tile.GROUND;
            }
        }
        return map;
    }
    public World getWorld(){return world;}
    public ArrayList<EntityController> getEntities(){return Entities;}
    
}
