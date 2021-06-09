import java.util.Random;

class CharacterController extends EntityController{
  public CharacterController(Character model, CharacterView view){
    super(model, view);
  }
  public void onCollison(EntityController colPartnerEntity){
    //colPartner.getModel().setCharacter("*");
    CharacterController colPartner = (CharacterController) colPartnerEntity;
    Character colPartnerModel = (Character) colPartner.getModel();
    colPartnerModel.setHealth(colPartnerModel.getHealth() - 20);
  }

  public void update(){
    Random rand = new Random();

    toX = rand.nextInt(10);
    toY = rand.nextInt(5);

    if(((Character) model).isDead()){
      System.out.println("Dead");
      view.setRenderable(false);
    }
  }
}