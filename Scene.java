import java.util.Arrays;
import java.util.Map;
import java.util.ArrayList;
import java.util.Random;

//model class for sceneController
public class Scene {
    private World world;
    private ArrayList<EntityController> Entities;
    private int playerIDX;

    public Scene(ViewBox vb){
        Entities = new ArrayList<EntityController>();
        //generates 5 character enemies
        for(int i =0; i<5;i++){
            Character character = new Character(i,0, "d",100);
            CharacterView view = new CharacterView(vb);

            Entities.add(new CharacterController(character, view));
        }
        //adds player
        Player player = new Player(5, 5);
        PlayerView view = new PlayerView(vb);
        Entities.add(new PlayerController(player, view));
        playerIDX = Entities.size()-1;

        //generates map
        world = new World(generateMap(20, 20));
    }
    public Tile[][] generateMap(int height, int width){
        Tile[][] map = new Tile[height][width];

        //was going to add terrain generation, but ran out of time, so just generates a flat world
        float chanceWall = .50f;
        Random rand = new Random();
        for(int x=0;x<height;x++){
            for(int y=0;y<width;y++){
                if(rand.nextFloat() < chanceWall){
                  map[x][y] = Tile.GROUND;
                }else{
                  map[x][y] = Tile.GROUND;
                }
            }
        }
        return map;
    }
    public World getWorld(){return world;}
    public PlayerController getPlayer(){
      return (PlayerController) Entities.get(playerIDX);
    }
    public ArrayList<EntityController> getEntities(){return Entities;}
    public void setEntities(ArrayList<EntityController> ecs){Entities = ecs;}
}
