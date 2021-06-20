
public abstract class Gameloop {
    public Gameloop(){
        ViewBox vb = new ViewBox(20, 20);
        Scene scene = new Scene(vb);
        TerminalView t = new TerminalView();
        SceneView s = new SceneView(vb);
        SceneController sc = new SceneController(t,s, scene);
        while(true){
            //handle phyics and rendering here per frame
            sc.update();
            sc.render();
            sc.processInput();

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
