package university.jala.capstonelegion.enums;

public enum CharacterSymbol {
    COMMANDER(10,'C'),
    MEDIC(20, 'M'),
    TANK(30, 'T'),
    SNIPER(40, 'S'),
    INFANT(50, 'I'),
    ANTIAIRCRAFT(60,'A'),
    ENGINEER(70,'E'),
    GUNNER(80,'G');



    private int numberSymbol;
    private char symbol;

    private CharacterSymbol(int numberSymbol, char symbol) {
        this.numberSymbol = numberSymbol;
        this.symbol = symbol;
    }

    public char getSymbol() {
        return symbol;
    }
    public int getNumberSymbol() {
        return numberSymbol;
    }
}
