package university.jala.capstonelegion.enums;

public enum AlgorithmEnum {
    SORT("Selection sort", "S"),
    BUBBLE_SORT("Bubble sort", "B"),
    INSERTION_SORT("Insertion sort", "I"),
    MERGE_SORT("Merge sort", "M"),
    QUICK_SORT("Quick sort", "Q"),
    HEAP_SORT("Heap sort", "H"),
    CURTING_SORT("Curtain sort", "C"),
    RADIX_SORT("Radix sort", "R");


    private String name;
    private String symbol;


    AlgorithmEnum(String name, String symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public String getSymbol() {
        return symbol;
    }



}
