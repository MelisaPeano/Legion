package university.jala.capstonelegion.sortStrategy;

import university.jala.capstonelegion.printer.PrintManager;

import java.util.ArrayList;
import java.util.List;

public class QuickSortStrategy extends Compare implements SortStrategy {
    private PrintManager printManager;
    private int timeOfOrdering;

    public QuickSortStrategy() {
        this.printManager = new PrintManager();
        this.timeOfOrdering = 0;
    }

    private int partition(Object[] array, int low, int high, Object parameterType,
                          List<Object[][]> steps, int rows, int columns) {
        Object lastPivot = array[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (compare(array[j], lastPivot, parameterType) <= 0) {
                i++;
                swap(array, i, j);
                steps.add(toMatrixCopy(array, rows, columns));
            }
        }
        swap(array, i + 1, high);
        steps.add(toMatrixCopy(array, rows, columns));
        timeOfOrdering++;
        return i + 1;
    }
    private void swap(Object[] array, int i, int j) {
        Object temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    private Object[] quickSort(Object[] array, int low, int high, Object parameterType,
                               List<Object[][]> steps, int rows, int columns) {
        if (low < high) {
            int pivotIndex = partition(array, low, high, parameterType, steps, rows, columns);
            quickSort(array, low, pivotIndex - 1, parameterType, steps, rows, columns);
            quickSort(array, pivotIndex + 1, high, parameterType, steps, rows, columns);
        }
        return array;
    }

    @Override
    public Object[] sort(Object[] array, Object type, int rows, int columns, int speed) {
        List<Object[][]> steps = new ArrayList<>();
        Object[] result = quickSort(array, 0, array.length - 1, type, steps, rows, columns);
        printManager.print(steps, type);
        return result;
    }

    @Override
    public int getTimeOfOrdering() {
        return timeOfOrdering;
    }

    @Override
    public void setTimeOfOrdering(int time) {
        this.timeOfOrdering = time;
    }
}
