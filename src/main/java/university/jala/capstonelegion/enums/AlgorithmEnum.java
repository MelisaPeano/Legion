package university.jala.capstonelegion.enums;

public enum AlgorithmEnum {
    BUBBLE_SORT("Bubble sort", "B"),
    INSERTION_SORT("Insertion sort", "I"),
    MERGE_SORT("Merge sort", "M"),
    QUICK_SORT("Quick sort", "Q");

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
