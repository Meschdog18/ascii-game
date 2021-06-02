//although would be eaiser to support just holding just the entites x,y location, rather than having a whole 2d layer, if ever want to support multiple char sprites, will be very beneifical

public class EntityView extends Layer {
    private int x;
    private int y;
    private String symbol;
    public EntityView(int rowRange, int colRange){
        super(rowRange, colRange);
        layerPriority = 1;
    }
    public void update(int x, int y, String symbol){
        layerBuffer[this.x][this.y] = null;//clear out old pos

        this.x = x;
        this.y = y;
        this.symbol = symbol;

    }
    public void createLayer(){
        layerBuffer[x][y] = character;

    }
    public String getSymbol(){
        return symbol;
    }
}