class Character extends Entity{
  private int maxHealth;
  private int currentHealth;
  private boolean isDead; 
  protected int balance;
  protected int exp;
  private int lvl;
  public Character(int x, int y, String character,int maxHealth){
    super(x, y, character);
    this.maxHealth = maxHealth;
    currentHealth = maxHealth;
  }

  public boolean isDead(){return (currentHealth <= 0);}
  public int getHealth(){return currentHealth;}
  public void setHealth(int health){currentHealth = health;}
  public int getBalance(){return balance;}
  public void setExp(int exp){this.exp = exp;}
  public int getExp(){return exp;}
  public int getLevel(){//returns calculated level
    if(exp > lvl * 10 * 10){
      lvl++;
    }
    return lvl;
  }
}
