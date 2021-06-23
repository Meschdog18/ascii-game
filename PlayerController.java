import utility.KeyboardListener;
import java.util.ArrayList;

//player class which inherits entity/character and implements keyboard listener so it can react to keyboard input
public class PlayerController extends CharacterController implements KeyboardListener{
  
  public PlayerController(Player model, PlayerView view){
    super(model, view);
  }

  @Override
  public void update(){
    Character model = (Character) getModel();
    ((CharacterView) view).updateStatusMessage("Player Health: "+String.valueOf(model.getHealth()));

    //just ends the game if the player dies
    if(model.getHealth() < 0){
      System.out.println("You died!");
      System.exit(0);
    }
  }

  public void onKeyPress(String key){

    switch(key.toLowerCase()){
      case "fowards":
      case "w":
        toX--;
        break;

      case "backwards":
      case "s":
        toX++;
        break;

      case "left":  
      case "a":
        toY--;
        break;

      case "right":
      case "d":
        toY++;
        break;

      case "ak":
      case "attack":
        //find if there's an attackable neighbor
        EntityController ec = findNeighbors(ecsBuffer);
        if(ec != null){
          for(int i =0;i<ecsBuffer.size();i++){
            if(ec == ecsBuffer.get(i)){
              CharacterController other = (CharacterController) ec;
              attackOther(other);
              Character model = (Character) other.getModel();
              ((CharacterView) view).updateStatusMessage("Enemy Health: "+String.valueOf(model.getHealth()));
             //call their onAttack (apply's any defense, or in case of an nonplayer tells them who to attack in return)
             other.onAttack(ecsBuffer.indexOf(this));
            ecsBuffer.set(i, other); //updates ecsBuffer
              

            }
          }

        }
        break;
    }
  }
}