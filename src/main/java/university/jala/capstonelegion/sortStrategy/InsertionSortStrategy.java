package university.jala.capstonelegion.sortStrategy;

import university.jala.capstonelegion.printer.PrintManager;

import java.util.Collections;

public class InsertionSortStrategy extends Compare implements SortStrategy {
    private final TimeManagerGame timeManagerGame;
    private final PrintManager printManager;
    private int timeOfOrdering;

    public InsertionSortStrategy() {
        this.printManager = new PrintManager();
        this.timeOfOrdering = 0;
        this.timeManagerGame = new TimeManagerGame();
    }

    public Object[] orderByInsertion(
            Object[] orderArray,
            Object type,
            int rows,
            int columns,
            int speed
    ) {

        for (int i = 1; i < orderArray.length; i++) {
            if (timeManagerGame.isStopRequested()) return orderArray;
            Object troop = orderArray[i];
            int j = i - 1;

            while (j >= 0 && compare(orderArray[j], troop, type) > 0) {
                if (timeManagerGame.isStopRequested()) return orderArray;
                orderArray[j + 1] = orderArray[j];
                j--;
            }
            orderArray[j + 1] = troop;
            Object[][] snapshot = toMatrixCopy(orderArray, rows, columns);
            printManager.print(Collections.singletonList(snapshot), type);
            timeManagerGame.sleepSpeed(speed);
            timeOfOrdering++;
        }
        return orderArray;
    }

    @Override
    public Object[] sort(Object[] array, Object type, int rows, int columns, int speed) {
        timeManagerGame.stopGame();
        return orderByInsertion(array, type, rows, columns, speed);

    }

    @Override
    public int getTimeOfOrdering() {
        return timeOfOrdering;
    }

}
