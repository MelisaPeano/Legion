package university.jala.capstonelegion.sortStrategy.factory;

import university.jala.capstonelegion.enums.AlgorithmEnum;
import university.jala.capstonelegion.sortStrategy.BubbleSortStrategy;
import university.jala.capstonelegion.sortStrategy.InsertionSortStrategy;
import university.jala.capstonelegion.sortStrategy.QuickSortStrategy;
import university.jala.capstonelegion.sortStrategy.SortStrategy;

public class SortStrategyFactory {

    public static SortStrategy getStrategy(AlgorithmEnum algorithm) {
        return switch (algorithm) {
            case INSERTION_SORT -> new InsertionSortStrategy();
            case BUBBLE_SORT    -> new BubbleSortStrategy();
            case QUICK_SORT     -> new QuickSortStrategy();
            default -> throw new IllegalArgumentException(
                    "Algorithm not supported: " + algorithm
            );
        };
    }
}
