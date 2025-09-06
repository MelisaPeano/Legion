package university.jala.capstonelegion.sortStrategy;

import university.jala.capstonelegion.printer.PrintManager;

import java.util.ArrayList;
import java.util.List;

public class InsertionSortStrategy extends Compare implements SortStrategy {
    private PrintManager printManager;
    private int timeOfOrdering;

    public InsertionSortStrategy() {
        this.printManager = new PrintManager();
        this.timeOfOrdering = 0;
    }

    public Object[] orderByInsertion(Object[] orderArray, Object type, List<Object[][]> steps, int rows, int columns) {

        for (int i = 1; i < orderArray.length; i++) {
            Object troop = orderArray[i];
            int j = i - 1;

            while (j >= 0 && compare(orderArray[j], troop, type) > 0) {
                orderArray[j + 1] = orderArray[j];
                j--;
                steps.add(toMatrixCopy(orderArray, rows, columns));
            }
            orderArray[j + 1] = troop;
            steps.add(toMatrixCopy(orderArray, rows, columns));
            timeOfOrdering++;
        }
        return orderArray;
    }

    @Override
    public Object[] sort(Object[] array, Object type, int rows, int columns, int speed) {
        List<Object[][]> steps = new ArrayList<>();
        Object[] result = orderByInsertion(array, type, steps, rows, columns);
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
