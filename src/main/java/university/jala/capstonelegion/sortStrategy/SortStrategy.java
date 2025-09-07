package university.jala.capstonelegion.sortStrategy;

public interface SortStrategy {

    Object[] sort(Object[] array, Object type, int rows, int columns, int speed);

    default Object[][] toMatrixCopy(Object[] flatArray, int rows, int columns) {
        Object[][] copyMatrix = new Object[rows][columns];
        for (int index = 0; index < flatArray.length; index++) {
            copyMatrix[index / columns][index % columns] = flatArray[index];
        }
        return copyMatrix;
    }

    int getTimeOfOrdering();

}
