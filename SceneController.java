import java.util.ArrayList;

//class that handles most of the high level logic of the game
public class SceneController{
    private SceneView sceneView;
    private TerminalView terminalView;
    private Scene scene;

    public SceneController(TerminalView terminalView,SceneView sceneView, Scene scene){
        this.sceneView = sceneView;
        this.terminalView = terminalView;
        this.scene = scene;
    }
    public void update(){
      //gets called every frame

        ArrayList<EntityController> ecs = scene.getEntities();

        for(EntityController entity : ecs){
          
          //if entity isDeactivated don't bother rendering, updating, etc, just ignore

          if(entity.isDeactivated()){
            continue;
          }
//pass all entities in game to each entity, so //they can preform certain functions (ie, find neighbors)
          entity.setEcsBuffer(ecs);
          //calls entity update 
            entity.update(); 
          
            for(EntityController colPartner : ecs){
                //checks for collions
                
                Entity colPModel = colPartner.getModel();
                Entity entityModel = entity.getModel();

                if((entity.getXBuffer() == colPModel.getX() && entity.getYBuffer() == colPModel.getY()) && entity != colPartner){
                    //trigger onCollison
                    entity.onCollison(colPartner);
                }else{
                  // if no collison, move entity to pos
                  
                    if(entity.getXBuffer() != entityModel.getX() || entity.getYBuffer() != entityModel.getY()){
                      entity.setLocation(entity.getXBuffer(), entity.getYBuffer());
                    }
                    
                }
            }
          
          ecs = entity.getEcsBuffer();
         
        }
        //updates entities in scene
        scene.setEntities(ecs);
        sceneView.update(ecs, scene.getWorld());//updates sceneview, so it can prepare the render


    }
    public void render(){
        //combines all entites, map, status message into one 2d array which can be rendered in the terminalView
        sceneView.createLayer();
        sceneView.combineStatusMessages();
        terminalView.renderScene(sceneView);
    }
    public void processInput(){
        String in = terminalView.getInput();
        //pump this into the player update function
        PlayerController player = scene.getPlayer();
        player.onKeyPress(in);//maybe add array for all keypress listeners that impliment keyboardlistener interface
    }
}
