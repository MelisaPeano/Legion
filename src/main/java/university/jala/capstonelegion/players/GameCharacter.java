package university.jala.capstonelegion.players;

public class GameCharacter {
    private final String name;
    private final char symbol;
    private final int symbol2;

    public GameCharacter(String name, char symbol, int symbol2) {
        this.name = name;
        this.symbol = symbol;
        this.symbol2 = symbol2;
    }
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + " (" + symbol + ")";
    }
    public char getSymbol() {
        return symbol;
    }
    public int getNumberSymbol() {
        return symbol2;
    }

}
