import utility.Color;

public class Renderer {
    //renderers based of 2d array
    //store full map in mem, only render in load portion in load distance, ex 5x5 from center
    public Renderer(){
        
    }
    
    public void renderLayer(Layer layer){
        clearScreen();

        String[][] layerBuffer = layer.getLayer();

        for(int row = 0; row < layerBuffer.length; row++){
            for(int col = 0; col < layerBuffer[row].length; col++){
                System.out.print(layerBuffer[row][col]);
            }
            System.out.println();
        }

    
    }
    private void clearScreen(){
        System.out.print("\033[H\033[2J");  
        System.out.flush(); 
    }
}
