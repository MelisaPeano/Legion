package university.jala.capstonelegion.sortStrategy;

import university.jala.capstonelegion.printer.PrintManager;

import java.util.ArrayList;
import java.util.List;


public class BubbleSortStrategy extends Compare implements SortStrategy {
    private final PrintManager printManager;
    private int timeOfOrdering;

    public BubbleSortStrategy() {
        this.printManager = new PrintManager();
        this.timeOfOrdering = 0;
    }
    public Object[] orderByBubbleSort(Object[] orderArray, Object parameterType, int rows, int columns) {
        List<Object[][]> steps = new ArrayList<>();
        int allTroopsInArray = orderArray.length;
        for (int i = 0; i < allTroopsInArray - 1; i++) {
            for (int j = 0; j < allTroopsInArray - 1 - i; j++) {
                if (compare(orderArray[j], orderArray[j + 1], parameterType) > 0) {
                    Object objectTroop = orderArray[j];
                    orderArray[j] = orderArray[j + 1];
                    orderArray[j + 1] = objectTroop;

                    steps.add(toMatrixCopy(orderArray, rows, columns));
                }
            }
            timeOfOrdering++;
        }
        printManager.print(steps, parameterType);
      return orderArray;
    }

    @Override
    public Object[] sort(Object[] array, Object type, int rows, int columns, int speed) {
        return orderByBubbleSort(array, type, rows, columns);
    }

    @Override
    public int getTimeOfOrdering() {
        return this.timeOfOrdering;
    }

    @Override
    public void setTimeOfOrdering(int time) {
        this.timeOfOrdering = time;
    }

}
