package university.jala.capstonelegion;

import university.jala.capstonelegion.sortStrategy.*;
import university.jala.capstonelegion.enums.AlgorithmEnum;
import university.jala.capstonelegion.enums.OrientationType;
import university.jala.capstonelegion.sortStrategy.factory.SortStrategyFactory;

public class TroopOrdering extends Compare {
    private final QuickSortStrategy quickSortStrategy;
    private final InsertionSortStrategy insertionSortStrategy;
    private final BubbleSortStrategy bubbleSortStrategy;

    public TroopOrdering() {
        this.quickSortStrategy = new QuickSortStrategy();
        this.insertionSortStrategy = new InsertionSortStrategy();
        this.bubbleSortStrategy = new BubbleSortStrategy();
    }

    public Object[][] prepareToOrder(
            AlgorithmEnum algorithm,
            int rows, int columns,
            Object[][] fields,
            Object type,
            String orientation,
            int speed
    ) {
        Object[] flattenArray = flattenMatrix(rows, columns, fields);
        System.out.println("\n" + "Ordering By algorithm: " + algorithm + "\n");

        SortStrategy strategy = SortStrategyFactory.getStrategy(algorithm);
        flattenArray = strategy.sort(flattenArray, type, rows, columns,speed);
        System.out.println("Interactions of ordering with " + algorithm + ": "+ strategy.getTimeOfOrdering());

        // reconstruyo matriz
        int index = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                fields[i][j] = flattenArray[index++];
            }
        }

        Object[][] lastMatrix = checkTroopType(rows, columns, flattenArray, type);
        Object[] groupedArray = flattenMatrix(rows, columns, lastMatrix);

        return addOrientation(orientation, rows, columns, lastMatrix, groupedArray);

    }

    public Object[][] checkTroopType(
            int rows,
            int columns,
            Object[] orderArray,
            Object type
    ) {
        Object[][] checkMatrix = new Object[rows][columns];
        int indexRow = 0, indexColumn = 0;
        Object prevTroop = null;

        for (Object troop : orderArray) {
            if (troop == null) continue;
            if (prevTroop != null && compare(prevTroop, troop, type) != 0) {
                indexRow++;
                indexColumn = 0;
            }
            if (indexRow >= rows) break;
            if (indexColumn >= columns) {
                indexRow++;
                indexColumn = 0;
                if (indexRow >= rows) break;
            }
            checkMatrix[indexRow][indexColumn++] = troop;
            prevTroop = troop;
        }
        return checkMatrix;
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
            Object[][] fields,
            Object[] orderArray) {
        int index = 0;
        OrientationType key = OrientationType.fromOrientation(orientation);
        switch (key) {
            case NORTH_TO_SOUTH:
                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < columns; j++) {
                        fields[i][j] = orderArray[index++];
                    }
                }
                return fields;
            case SOUTH_TO_NORTH:
                for (int i = rows - 1; i >= 0; i--) {
                    for (int j = 0; j < columns; j++) {
                        fields[i][j] = orderArray[index++];
                    }
                }
                return fields;
            case WEST_TO_EAST:
                for (int j = 0; j < columns; j++) {
                    for (int i = 0; i < rows; i++) {
                        fields[i][j] = orderArray[index++];
                    }
                }
                return fields;
            case EAST_TO_WEST:
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
