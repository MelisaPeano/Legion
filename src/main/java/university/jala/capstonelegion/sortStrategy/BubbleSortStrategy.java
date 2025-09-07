package university.jala.capstonelegion.sortStrategy;

import university.jala.capstonelegion.printer.PrintManager;

import java.util.Collections;


public class BubbleSortStrategy extends Compare implements SortStrategy {
    private final PrintManager printManager;
    private int timeOfOrdering;
    private final TimeManagerGame timeManager;

    public BubbleSortStrategy() {
        this.printManager = new PrintManager();
        this.timeOfOrdering = 0;
        this.timeManager = new TimeManagerGame();
    }
    public Object[] orderByBubbleSort(
            Object[] orderArray,
            Object parameterType,
            int rows,
            int columns,
            int speed) {

        int allTroopsInArray = orderArray.length;
        for (int i = 0; i < allTroopsInArray - 1; i++) {
            for (int j = 0; j < allTroopsInArray - 1 - i; j++) {
                if (timeManager.isStopRequested()) return orderArray;
                if (compare(orderArray[j], orderArray[j + 1], parameterType) > 0) {
                    Object objectTroop = orderArray[j];
                    orderArray[j] = orderArray[j + 1];
                    orderArray[j + 1] = objectTroop;

                    Object[][] snapshot = toMatrixCopy(orderArray, rows, columns);
                    printManager.print(Collections.singletonList(snapshot), parameterType);
                    timeManager.sleepSpeed(speed);
                }
            }
            timeOfOrdering++;
        }
      return orderArray;
    }

    @Override
    public Object[] sort(Object[] array, Object type, int rows, int columns, int speed) {
        timeManager.stopGame();
        return orderByBubbleSort(array, type, rows, columns, speed);
    }

    @Override
    public int getTimeOfOrdering() {
        return this.timeOfOrdering;
    }

}
