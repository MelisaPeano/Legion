package university.jala.capstonelegion.printer;

import university.jala.capstonelegion.players.GameCharacter;

public class PrintManager {

    public void print(Object [][] fields, Object type) {
        for (int i = 0; i < fields.length; i++) {
            for (int j = 0; j < fields[0].length; j++) {
                Object field = fields[i][j];
                if (field instanceof GameCharacter) {
                    GameCharacter ch = (GameCharacter) field;
                    if(type.equals("c")) {
                        System.out.print(ch.getSymbol() + "\t");
                    }else{
                        System.out.print(ch.getNumberSymbol() + "\t");
                    }
                } else {
                    System.out.print("*\t");
                }
            }
            System.out.println();
        }
    }

}
