import java.util.Random;
import java.util.Map;

abstract public class Layer {
    private int rowRange;
    private int colRange;
    protected String layerBuffer[][];
    protected int layerPriority; //how high up this layer sits relative to other layers, with 1 being the highest layer
    public Layer(int rowRange, int colRange){
        //view box
        this.rowRange = rowRange;
        this.colRange = colRange;
        layerBuffer = new String[this.rowRange][this.colRange];
    }

    abstract public void createLayer();
    public String getPointOnLayer(int x, int y){
        if(x<0 || x>= layerBuffer.length || y < 0 || y >= layerBuffer[x].length){
            return null; //out of bounds
        }else{
            return layerBuffer[x][y];

        }
    }
    public String[][] getLayerBuffer(){
        return layerBuffer;
    }
}
