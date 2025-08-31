package university.jala.capstonelegion;

import university.jala.capstonelegion.algorithm.*;
import university.jala.capstonelegion.enums.AlgorithmEnum;
import university.jala.capstonelegion.enums.OrientationType;


public class TroopOrdering extends Compare {
    private final MergeSort mergeSort;
    private final QuickSort quickSort;
    private final Insertion insertion;
    private final BubbleSort bubbleSort;

    public TroopOrdering() {
        this.mergeSort = new MergeSort();
        this.quickSort = new QuickSort();
        this.insertion = new Insertion();
        this.bubbleSort = new BubbleSort();
    }

    public Object[][] prepareToOrder(
            AlgorithmEnum algorithm,
            int rows, int columns,
            Object[][] fields,
            Object type,
            String orientation
    ) {
        Object[] flattenArray = flattenMatrix(rows, columns, fields);
        System.out.println("\n" + "Ordering By algorithm: " + algorithm + "\n");
        switch (algorithm) {
            case INSERTION_SORT -> {
                flattenArray = insertion.orderByInsertion(flattenArray, type);

                Object[][] lastMatrix = checkTroopType(rows, columns, flattenArray, type);

                Object[] groupedArray = flattenMatrix(rows, columns, lastMatrix);

                return addOrientation(orientation, rows, columns, lastMatrix, groupedArray);

            }
            case BUBBLE_SORT -> {
                flattenArray = bubbleSort.orderByBubbleSort(flattenArray, type);

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
            case MERGE_SORT -> {
                flattenArray = mergeSort.orderByMergeSort(flattenArray, type);

                Object[][] lastMatrix = checkTroopType(rows, columns, flattenArray, type);

                Object[] groupedArray = flattenMatrix(rows, columns, lastMatrix);

                return addOrientation(orientation, rows, columns, lastMatrix, groupedArray);


            }
            case QUICK_SORT -> {
                flattenArray = quickSort.orderByQuickSort(flattenArray, type);

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
            default -> throw new IllegalArgumentException("Algorithm not supported : " + algorithm);


        }

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
