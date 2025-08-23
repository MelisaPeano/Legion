package university.jala.capstonelegion;


public interface Algorithm {
    Object [][] orderByInsertion(
            int rows,
            int columns,
            Object[][] fields,
            Object types,
            String orientation);
    Object[][] orderByHeapSort(
            int rows,
            int columns,
            Object[][] fields,
            Object parameterType,
            String orientation);
    Object[][] orderByBubbleSort(
            int rows,
            int columns,
            Object[][] fields,
            Object parameterType,
            String orientation);
    // I will add the other algorithm soon.
}
