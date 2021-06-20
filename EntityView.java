//although would be eaiser to support just holding just the entites x,y location, rather than having a whole 2d layer, if ever want to support multiple char sprites, will be very beneifical

//base view class
public class EntityView extends Layer {
    private int x;
    private int y;
    private String character;
    private boolean renderable;
    private ViewBox viewBox;
    public EntityView(ViewBox vb){
        super(vb.getDimX(), vb.getDimY());
        viewBox = vb;
        layerPriority = 1;
        renderable = true;
    }
    public void update(int x, int y, String character){
        layerBuffer[this.x][this.y] = null;//clear out old pos
      
        this.x = x;
        this.y = y;
        this.character = character;
    }
    public void createLayer(){
      layerBuffer[x][y] = character;
    }
    public String getCharacter(){
        return character;
    }
    public boolean isRenderable(){return renderable;}
    public void setRenderable(boolean renderable){this.renderable = renderable;}
    public ViewBox getViewBox(){return viewBox;}
}