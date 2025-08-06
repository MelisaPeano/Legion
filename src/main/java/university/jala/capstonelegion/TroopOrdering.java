package university.jala.capstonelegion;

import university.jala.capstonelegion.players.GameCharacter;

public class TroopOrdering implements Algorithm {
    public Object[][] orderByInsertion(int rows, int columns, Object[][] fields, Object type) {

        int total = rows * columns;
        Object[] orderArray = new Object[total];

        int index = 0;
        for (Object[] row : fields) {
            for (Object val : row) {
                orderArray[index++] = val;
            }
        }
        for (int i = 1; i < orderArray.length; i++) {
            Object key = orderArray[i];
            int j = i - 1;

            while (j >= 0 && compare(orderArray[j], key, type) > 0) {
                orderArray[j + 1] = orderArray[j];
                j--;
            }
            orderArray[j + 1] = key;
        }

        index = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                fields[i][j] = orderArray[index++];
            }
        }
        return fields;
    }

    private static int compare(Object o1, Object o2, Object type) {
        if (o1 == null && o2 == null) return 0;
        if (o1 == null) return 1;
        if (o2 == null) return -1;


        if (o1 instanceof GameCharacter && o2 instanceof GameCharacter) {
            GameCharacter g1 = (GameCharacter) o1;
            GameCharacter g2 = (GameCharacter) o2;
            if (type.equals("c")) {
                return Integer.compare(g1.getSymbol(), g2.getSymbol());
            } else if (type.equals("n")) {
                return Integer.compare(g1.getNumberSymbol(), g2.getNumberSymbol());
            }

        }
        return 0;
    }

}
