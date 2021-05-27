import java.util.Arrays;
import java.util.Map;


public class Scene {
    private World world;
    private Entity[] Entities;

    public Scene(){
        Entities = new Entity[3];
        for(int i =0; i<Entities.length;i++){
            Entities[i] = new Entity(i, 0);
        }
        world = new World(generateMap(10, 5));
    }
    public void update(){
        //check for collisons
        for(Entity entity : Entities){
            entity.update();
            for(Entity colPartner : Entities){
                if(entity.getToX() == colPartner.getX() && entity.getToY() == colPartner.getY()){
                    //trigger onCollison
                    break;
                }else{
                    entity.setLocation(entity.getToX(), entity.getToY());
                }
            }
        }
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
    public Entity[] getEntities(){return Entities;}
    
}
