package university.jala.capstonelegion.enums;

public enum AlgorithmEnum {
    SORT("Selection sort", "S", "s"),
    BUBBLE_SORT("Bubble sort", "B", "b"),
    INSERTION_SORT("Insertion sort", "I", "i"),
    MERGE_SORT("Merge sort", "M", "m"),
    QUICK_SORT("Quick sort", "Q", "q"),
    HEAP_SORT("Heap sort", "H", "h"),
    CURTING_SORT("Curtain sort", "C", "c"),
    RADIX_SORT("Radix sort", "R", "r");


    private String name;
    private String symbol;
    private String symbol2;

    AlgorithmEnum(String name, String symbol, String symbol2) {
        this.name = name;
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getSymbol2() {
        return symbol2;
    }
}
