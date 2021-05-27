
public abstract class Gameloop {
    public Gameloop(){
        Renderer renderer = new Renderer();
        Scene scene = new Scene();
        while(true){
            //handle phyics and rendering here per frame
            scene.update();
            Layer layer = new Layer(scene);
            layer.createLayer();
            renderer.renderLayer(layer);

            loop();
            try {
                Thread.sleep(200);
             } catch (Exception e) {
                System.out.println(e);
             }
    
        }
    }
    
    abstract public void loop();
}
