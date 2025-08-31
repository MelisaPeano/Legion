package university.jala.capstonelegion.algorithm;

public class QuickSort extends Compare {
    public Object[] orderByQuickSort( Object[] orderArray, Object parameterType) {

        return quickSort(orderArray, 0, orderArray.length - 1, parameterType);
    }
    private int partition(Object[] array, int low, int high, Object parameterType) {

        Object lastPivot = array[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (compare(array[j], lastPivot, parameterType) <= 0) {
                i++;
                swap(array, i, j);
            }
        }
        swap(array, i + 1, high);
        return i + 1;
    }
    private void swap(Object[] array, int i, int j) {
        Object temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    private Object[] quickSort(Object[] array, int low, int high, Object parameterType) {
        if (low < high) {
            int pivotIndex = partition(array, low, high, parameterType);
            quickSort(array, low, pivotIndex - 1, parameterType);
            quickSort(array, pivotIndex + 1, high, parameterType);
        }
        return array;
    }

}
