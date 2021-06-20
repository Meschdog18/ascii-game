//just makes it easy to maintain same size layers across all the view classes
public class ViewBox{
  private int dimX;
  private int dimY;

  public ViewBox (int x, int y){
    dimX = x;
    dimY = y;
  }

  public int getDimX(){return dimX;}
  public int getDimY(){return dimY;}
}