import utility.Color;
public class App extends Gameloop {
    public App(){
        super();
    }
    public static void main(String[] args) 
    {
        System.out.println(Color.ANSI_RESET);
        App a = new App();
        //Entity[] lis = new Entity[5];
       /// lis[0] = new Character(1, 1, 100);
       // Character c = (Character)lis[0];
      ////  System.out.println(c.isDead());
      //do this ^, just check for instance type and cast it

        //ArrayList<Entity> players = new ArrayList<>();

        //Character cc = new Character(1, 1, 100);
        //players.add(cc);

        //players.get(0).test();
    }
    public void loop(){
    }
}

