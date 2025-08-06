package university.jala.capstonelegion.players;

import university.jala.capstonelegion.enums.CharacterSymbol;

public abstract class GameCharacter {
    protected String name;
    protected int live;
    protected int speed;
    protected int force;
    protected int rank;
    protected char symbol;
    protected int symbol2;

    public GameCharacter(String name, int live, int speed, int force, int rank, CharacterSymbol symbol) {
        this.name = name;
        this.live = live;
        this.speed = speed;
        this.force = force;
        this.rank = rank;
        this.symbol = symbol.getSymbol();
        this.symbol2 = symbol.getNumberSymbol();
    }

    public char getSymbol() {
        return symbol;
    }
    public int getNumberSymbol() {
        return symbol2;
    }

}
