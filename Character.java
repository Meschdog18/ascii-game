class Character extends Entity{
  private int maxHealth;
  private int currentHealth;
  private boolean isDead; 

  public Character(int x, int y, int maxHealth){
    super(x, y);
    this.maxHealth = maxHealth;
    currentHealth = maxHealth;
  }

  public boolean isDead(){return (currentHealth <= 0);}
  public int getHealth(){return currentHealth;}
  public void setHealth(int health){currentHealth = health;}
}
