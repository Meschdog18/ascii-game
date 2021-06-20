import java.util.ArrayList;
class CharacterView extends EntityView{
  public CharacterView(ViewBox vb){
    super(vb);
  }
  public void updateStatusMessage(ArrayList<String> statusMessages){
    if(statusMessages.size() > 0){
      this.statusMessages.addAll(statusMessages);
    }
  }
  public void updateStatusMessage(String statusMessage){
    if(statusMessages != null){
      this.statusMessages.add(statusMessage);
    }
  }
}