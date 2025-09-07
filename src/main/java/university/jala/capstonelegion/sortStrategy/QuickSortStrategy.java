package university.jala.capstonelegion.sortStrategy;

import university.jala.capstonelegion.printer.PrintManager;

import java.util.Collections;

public class QuickSortStrategy extends Compare implements SortStrategy {
    private final TimeManagerGame timeManager;
    private final PrintManager printManager;
    private int timeOfOrdering;

    public QuickSortStrategy() {
        this.printManager = new PrintManager();
        this.timeOfOrdering = 0;
        this.timeManager = new TimeManagerGame();
    }

    private int partition(Object[] array, int low, int high, Object parameterType,
                          int rows, int columns, int speed) {
        Object lastPivot = array[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (timeManager.isStopRequested()) return i;
            if (compare(array[j], lastPivot, parameterType) <= 0) {
                i++;
                swap(array, i, j);
                Object[][] snapshot = toMatrixCopy(array, rows, columns);
                printManager.print(Collections.singletonList(snapshot), parameterType);
                timeManager.sleepSpeed(speed);
                timeOfOrdering++;
            }
        }
        swap(array, i + 1, high);
        Object[][] snapshot = toMatrixCopy(array, rows, columns);
        printManager.print(Collections.singletonList(snapshot), parameterType);
        timeManager.sleepSpeed(speed);
        timeOfOrdering++;
        return i + 1;
    }

    private void swap(Object[] array, int i, int j) {
        Object temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private void quickSort(Object[] array, int low, int high, Object parameterType,
                           int rows, int columns, int speed) {
        if (timeManager.isStopRequested()) return;
        if (low < high) {
            int pivotIndex = partition(array, low, high, parameterType, rows, columns, speed);
            quickSort(array, low, pivotIndex - 1, parameterType, rows, columns, speed);
            quickSort(array, pivotIndex + 1, high, parameterType, rows, columns, speed);
        }
    }

    @Override
    public Object[] sort(Object[] array, Object type, int rows, int columns, int speed) {
        timeManager.stopGame();
        quickSort(array, 0, array.length - 1, type, rows, columns, speed);
        return array;

    }

    @Override
    public int getTimeOfOrdering() {
        return timeOfOrdering;
    }

}
