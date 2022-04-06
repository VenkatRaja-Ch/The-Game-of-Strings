public class
GamePlayer {

    private String name;
    private boolean hasWon;
    private char gameStringAssigned;
    private boolean isHuman;

    public String getName(){ return name; }
    public void setName( String name ) { this.name = name; }

    public boolean getHasWon() { return hasWon; }
    public void setHasWon( boolean hasWon ) { this.hasWon = hasWon; }

    public char getGameStringAssigned() { return gameStringAssigned; }
    public void setGameStringAssigned( char gameStringAssigned ) { this.gameStringAssigned = gameStringAssigned; }

    public boolean getIsHuman() { return  isHuman; }
    public void setIsHuman( boolean isHuman ) { this.isHuman = isHuman; }

    GamePlayer(){
        // default constructor
        name = "GamePlayer name to be set";
        hasWon = false;
        gameStringAssigned = '-';
        isHuman = false;
    }

    GamePlayer(String name, char gameStringAssigned, boolean isHuman ){
        this.name = name;
        hasWon = false;
        this.gameStringAssigned = gameStringAssigned;
        this.isHuman = isHuman;
    }
}
