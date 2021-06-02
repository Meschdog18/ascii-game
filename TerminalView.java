import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class TerminalView {
    public TerminalView(){

    }
    public String getInput(){
        String data = "";
        try{
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
 
            // Reading data using readLine
            data = reader.readLine();
        }catch(IOException ex){
            System.out.println (ex.toString());
        }
        
        return data;
    }
    public void renderScene(SceneView view){
        clearScreen();
        
        String[][] layerBuffer = view.getLayerBuffer();

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
