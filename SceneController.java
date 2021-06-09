import java.util.ArrayList;

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
        //move getTo to entity controller
        ArrayList<EntityController> ecs = scene.getEntities();
        sceneView.update(ecs, scene.getWorld());

        for(EntityController entity : ecs){
            entity.update();

            for(EntityController colPartner : ecs){
                if(entity.getXBuffer() == colPartner.getModel().getX() && entity.getYBuffer() == colPartner.getModel().getY()){
                    //trigger onCollison
                    entity.onCollison(colPartner);
                }else{
                    entity.setLocation(entity.getXBuffer(), entity.getYBuffer());
                }
            }
        }

    }
    public void render(){
        sceneView.createLayer();
        terminalView.renderScene(sceneView);
    }
    public void processInput(){
        String in = terminalView.getInput();
        System.out.println(in);
    }
}
