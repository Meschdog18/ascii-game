import java.util.Arrays;
import java.util.Map;


public class Scene {
    private World world;
    private EntityController[] Entities;

    public Scene(){
        Entities = new EntityController[3];
        for(int i =0; i<Entities.length;i++){
            Entity entity = new Entity(i, 0);
            EntityView view = new EntityView(10, 5);
            Entities[i] = new EntityController(entity, view);
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
    public EntityController[] getEntities(){return Entities;}
    
}
