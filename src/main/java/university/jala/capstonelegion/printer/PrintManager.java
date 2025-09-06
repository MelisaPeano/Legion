package university.jala.capstonelegion.printer;

import university.jala.capstonelegion.players.GameCharacter;

import java.util.List;

public class PrintManager {

    public void print(Object input, Object type) {
        if (input instanceof List<?>) {
            // Si es una lista de matrices
            List<?> list = (List<?>) input;
            for (Object item : list) {
                if (item instanceof Object[][]) {
                    printMatrix((Object[][]) item, type);
                    System.out.println(); // Separador entre matrices
                }
            }
        } else if (input instanceof Object[][]) {
            // Si es una sola matriz
            printMatrix((Object[][]) input, type);
        } else {
            System.out.println("El parámetro no es válido. Debe ser Object[][] o List<Object[][]>.");
        }
    }

    private void printMatrix(Object[][] fields, Object type) {
        for (int i = 0; i < fields.length; i++) {
            for (int j = 0; j < fields[0].length; j++) {
                Object field = fields[i][j];
                if (field instanceof GameCharacter) {
                    GameCharacter ch = (GameCharacter) field;
                    if (type.equals("c")) {
                        System.out.print(ch.getSymbol() + "\t");
                    } else {
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
