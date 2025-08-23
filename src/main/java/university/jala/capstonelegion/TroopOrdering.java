package university.jala.capstonelegion;

import university.jala.capstonelegion.players.GameCharacter;

public class TroopOrdering implements Algorithm {
    private static int compare(Object troop1, Object troop2, Object characterOrNumber) {
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

    public Object[][] orderByInsertion(
            int rows, int columns,
            Object[][] fields,
            Object type,
            String orientation) {

        Object[] orderArray = flattenMatrix(rows, columns, fields);

        for (int i = 1; i < orderArray.length; i++) {
            Object troop = orderArray[i];
            int j = i - 1;

            while (j >= 0 && compare(orderArray[j], troop, type) > 0) {
                orderArray[j + 1] = orderArray[j];
                j--;
            }
            orderArray[j + 1] = troop;
        }

        Object[][] lastMatrix = checkTroopType(rows, columns, orderArray, type);

        Object[] groupedArray = flattenMatrix(rows, columns, lastMatrix);

        return addOrientation(orientation, rows, columns, lastMatrix, groupedArray);
    }
    public Object[][] checkTroopType(
            int rows,
            int columns,
            Object[] orderArray,
            Object type
        ){
        Object[][] grouped = new Object[rows][columns];
        int r = 0, c = 0;
        Object prev = null;

        for (Object troop : orderArray) {
            if (troop == null) continue;
            if (prev != null && compare(prev, troop, type) != 0) {
                r++; c = 0;
            }
            if (r >= rows) break;
            if (c >= columns) { r++; c = 0; if (r >= rows) break; }
            grouped[r][c++] = troop;
            prev = troop;
        }
        return grouped;
    }

    public Object[][] orderByBubbleSort(
            int rows,
            int columns,
            Object[][] fields,
            Object parameterType,
            String orientation) {

        Object[] orderArray = flattenMatrix(rows, columns,fields);
        int allTroopsInArray = orderArray.length;
        for (int i = 0; i < allTroopsInArray - 1; i++) {
            for (int j = 0; j < allTroopsInArray - 1 - i; j++) {
                if (compare(orderArray[j], orderArray[j + 1], parameterType) > 0) {
                    Object objectTroop = orderArray[j];
                    orderArray[j] = orderArray[j + 1];
                    orderArray[j + 1] = objectTroop;
                }
            }
        }
        int index = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                fields[i][j] = orderArray[index++];
            }
        }
        Object[][] lastMatrix = checkTroopType(rows, columns, orderArray, parameterType);

        Object[] groupedArray = flattenMatrix(rows, columns, lastMatrix);

        return addOrientation(orientation, rows, columns, lastMatrix, groupedArray);

    }

    public Object[][] orderByHeapSort(
            int rows,
            int columns,
            Object[][] fields,
            Object parameterType,
            String orientation) {

        Object[] orderArray = flattenMatrix(rows, columns, fields);
        int allTroopsInArray = orderArray.length;

        for (int i = allTroopsInArray / 2 - 1; i >= 0; i--) {
            makeHeap(orderArray, allTroopsInArray, i, parameterType);
        }

        for (int i = allTroopsInArray - 1; i > 0; i--) {
            Object temp = orderArray[0];
            orderArray[0] = orderArray[i];
            orderArray[i] = temp;

            makeHeap(orderArray, i, 0, parameterType);
        }
        int index = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                fields[i][j] = orderArray[index++];
            }
        }
        Object[][] lastMatrix = checkTroopType(rows, columns, orderArray, parameterType);

        Object[] groupedArray = flattenMatrix(rows, columns, lastMatrix);

        return addOrientation(orientation, rows, columns, lastMatrix, groupedArray);
    }

    private void makeHeap(Object[] array, int n, int i, Object type) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && compare(array[left], array[largest], type) > 0) {
            largest = left;
        }

        if (right < n && compare(array[right], array[largest], type) > 0) {
            largest = right;
        }

        if (largest != i) {
            Object swap = array[i];
            array[i] = array[largest];
            array[largest] = swap;

            makeHeap(array, n, largest, type);
        }
    }

    public Object[] flattenMatrix(int rows, int columns, Object[][] fields) {
        int total = rows * columns;
        Object[] orderArray = new Object[total];

        int index = 0;
        for (Object[] row : fields) {
            for (Object val : row) {
                orderArray[index++] = val;
            }
        }
        return orderArray;
    }

    public Object[][] addOrientation(
            String orientation,
            int rows,
            int columns,
            Object [][] fields,
            Object[] orderArray ) {
        int index = 0;
        switch (orientation) {
            case "s":
                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < columns; j++) {
                        fields[i][j] = orderArray[index++];
                    }
                }
                return fields;
            case "n":
                for (int i = rows - 1; i >= 0; i--) {
                    for (int j = 0; j < columns; j++) {
                        fields[i][j] = orderArray[index++];
                    }
                }
                return fields;
            case "e":
                for (int j = 0; j < columns; j++) {
                    for (int i = 0; i < rows; i++) {
                        fields[i][j] = orderArray[index++];
                    }
                }
                return fields;
            case "w":
                for (int j = columns - 1; j >= 0; j--) {
                    for (int i = 0; i < rows; i++) {
                        fields[i][j] = orderArray[index++];
                    }
                }
                return fields;
            default:
                throw new IllegalArgumentException("Orientación desconocida: " + orientation);
        }
    }
}
