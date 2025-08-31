package university.jala.capstonelegion.algorithm;

import university.jala.capstonelegion.players.GameCharacter;

public abstract class Compare {
    protected static int compare(Object troop1, Object troop2, Object characterOrNumber) {
        if (troop1 == null && troop2 == null) return 0;
        if (troop1 == null) return 1;
        if (troop2 == null) return -1;

        if (troop1 instanceof GameCharacter troopCompare1 && troop2 instanceof GameCharacter troopCompare2) {
            if (characterOrNumber.equals("c")) {
                return Integer.compare(troopCompare1.getSymbol(), troopCompare2.getSymbol());
            } else if (characterOrNumber.equals("n")) {
                return Integer.compare(troopCompare1.getNumberSymbol(), troopCompare2.getNumberSymbol());
            }

        }
        return 0;
    }
}
