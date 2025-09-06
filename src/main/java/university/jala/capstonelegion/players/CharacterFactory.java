package university.jala.capstonelegion.players;


import university.jala.capstonelegion.enums.CharacterSymbol;

import java.util.ArrayList;
import java.util.List;

public class CharacterFactory {
    public List<GameCharacter> createCharacter(int[] amount) {
        List<GameCharacter> players = new ArrayList<>();

        int positionsToProcess = Math.min(amount.length, 8);

        for (int i = 0; i < positionsToProcess; i++) {
            CharacterSymbol type = CharacterSymbol.values()[i];
            int quantity = amount[i];

            for (int j = 0; j < quantity; j++) {
                String name = type.name().toLowerCase() + (j + 1);
                players.add(new GameCharacter(name, type.getSymbol(), type.getNumberSymbol()));
            }
        }

        return players;
    }

}
