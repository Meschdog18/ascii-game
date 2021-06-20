import java.util.Random;
import java.util.Map;
import java.util.ArrayList;

abstract public class Layer {
    private int rowRange;
    private int colRange;
    protected String layerBuffer[][];
    protected ArrayList<String> statusMessages;
    protected int layerPriority; //how high up this layer sits relative to other layers, with 1 being the highest layer
    public Layer(int rowRange, int colRange){
        //view box
        this.rowRange = rowRange;
        this.colRange = colRange;
        layerBuffer = new String[this.rowRange][this.colRange];
        statusMessages = new ArrayList<String>();
    }

    abstract public void createLayer();
    public String getPointOnLayer(int x, int y){
        if(!inBounds(x, y)){
            return null; //out of bounds
        }else{
            return layerBuffer[x][y];

        }
    }
    public boolean inBounds(int x, int y){
      if(x<0 || x>= layerBuffer.length || y < 0 || y >= layerBuffer[x].length){
            return false; //out of bounds
        }
      return true;
    }
    public String[][] getLayerBuffer(){
        return layerBuffer;
    }
    public ArrayList<String> getStatusMessages(){
      ArrayList<String> value = (ArrayList<String>)statusMessages.clone(); //just makes it a shallow copy, so when we clear the statusMessages arraylist before returning the value it doesn't also clear the value arraylist 
      statusMessages.clear();

      return value;
    }
}
