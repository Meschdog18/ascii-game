import utility.Color;

public enum Tile {
    GROUND('.', Color.ANSI_GREEN, true),
    WALL('#', Color.ANSI_BLACK, true);

    private char character;
    private Color color;
    private boolean blocking;
    
    private Tile(char character, Color color, boolean blocking){
        this.character = character;
        this.color = color;
        this.blocking = blocking;
    }

    public boolean isBlocking(){
        return blocking;
    }
    public char character(){return character;}
    public Color color(){return color;}
    public String toString(){
        return color.toString()+character+Color.ANSI_RESET;
    }
}
