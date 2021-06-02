class Character extends Entity{
  private int maxHealth;
  private int currentHealth;
  private boolean isDead;
  private 

  public Character(int x, int y, int maxHealth){
    super(x, y);
    this.maxHealth = maxHealth;
  }

  public boolean isDead(){return (currentHealth <= 0);}

}