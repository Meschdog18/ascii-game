import java.util.Random;
import java.util.ArrayList;
import utility.Color;
class CharacterController extends EntityController{
  private boolean inBattle;
  public CharacterController(Character model, CharacterView view){
    super(model, view);
  }
  public void onCollison(EntityController colPartnerEntity){
    //colPartner.getModel().setCharacter("*");
    CharacterController colPartner = (CharacterController) colPartnerEntity;
    Character colPartnerModel = (Character) colPartner.getModel();
    //colPartnerModel.setColor(Color.ANSI_BLUE);
    //colPartnerModel.setHealth(colPartnerModel.getHealth() - 20);
  }
  public void onAttack(int otherEcsIndex){
    if(deactivated){return;}

    if(!inBattle){inBattle = true;}

    CharacterController other = (CharacterController) ecsBuffer.get(otherEcsIndex);

    System.out.println(other.getModel().character());
    Random rand = new Random();

    float retaliate = rand.nextFloat();
    //90 percent chance to attack back who ever attacked 
    if(retaliate < .80f){
      attackOther(other);
    }
  }

  public CharacterController attackOther(CharacterController other){
    //attacks other character
    Character otherModel = (Character) other.getModel();
    otherModel.setHealth(otherModel.getHealth() - 40);
    if(otherModel.getHealth() < 0){
      inBattle = false; //inBattle just means the character can't move until battle finishs (one character dies)
    }
    return other;
  }
  public void update(){
    Random rand = new Random();

    ViewBox vb = view.getViewBox();
    if(!inBattle){
      float axisMove = rand.nextFloat();//determines on which axis to move

      //determines whether to move fowards, backwards, right, left
      if(axisMove < .50f){
        int x = model.getX();
        toX = x + rand.nextInt(1 + 2) - 1;
      }else{
        int y = model.getY();
        toY = y + rand.nextInt(1 + 2) - 1;
      }
      
    }
    //toX = rand.nextInt(vb.getDimX());
    //toY = rand.nextInt(vb.getDimY());

    //if model is killed, deactivate it and make it not render
    if(((Character) model).isDead() && !deactivated){
      ((CharacterView) view).updateStatusMessage("Enemy Killed");
      inBattle = false;
      view.setRenderable(false);
      deactivated = true;
    }
  }

  public EntityController findNeighbors(ArrayList<EntityController> ecs){
    //finds entitys infront, behind, or right or left of this entity
    Character ch = (Character) getModel();
    int cX = ch.getX();
    int cY = ch.getY();
    for(EntityController ec : ecs){
      Entity e = ec.getModel();
      int eX = e.getX();
      int eY = e.getY();
      if((cX == eX && (cY + 1 == eY || cY - 1 == eY)) || (cY == eY && (cX + 1 == eX || cX - 1 == eX))){
        return ec; //only returns first enemy in contact, regardless if there muliple in range (keeps it simple)
      }
      
    }
        return null;

  }
}