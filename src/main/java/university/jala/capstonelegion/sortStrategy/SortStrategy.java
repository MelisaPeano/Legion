package university.jala.capstonelegion.sortStrategy;

public interface SortStrategy {
    Object[] sort(Object[] array, Object type, int rows, int columns, int speed);
    default Object[][] toMatrixCopy(Object[] flat, int rows, int columns) {
        Object[][] m = new Object[rows][columns];
        for (int idx = 0; idx < flat.length; idx++) {
            m[idx / columns][idx % columns] = flat[idx];
        }
        return m;
    }
    int getTimeOfOrdering();
    void setTimeOfOrdering(int time);
}
