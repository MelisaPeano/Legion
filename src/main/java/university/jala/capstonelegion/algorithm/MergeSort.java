package university.jala.capstonelegion.algorithm;

public class MergeSort extends Compare {

    public Object[] orderByMergeSort(Object[] orderArray, Object parameterType) {
        orderByMergeSort(orderArray, 0, orderArray.length - 1, parameterType);
        return orderArray;
    }

    private void orderByMergeSort(Object[] orderArray, int left, int right, Object parameterType) {
        if (left < right) {
            int middle = (left + right) / 2;
            orderByMergeSort(orderArray, left, middle, parameterType);
            orderByMergeSort(orderArray, middle + 1, right, parameterType);
            merge(orderArray, left, middle, right, parameterType);
        }
    }

    private void merge(Object[] arr, int left, int middle, int right, Object parameterType) {
        int n1 = middle - left + 1;
        int n2 = right - middle;

        Object[] leftArray = new Object[n1];
        Object[] rightArray = new Object[n2];

        for (int i = 0; i < n1; i++) leftArray[i] = arr[left + i];
        for (int j = 0; j < n2; j++) rightArray[j] = arr[middle + 1 + j];

        int i = 0, j = 0, k = left;

        while (i < n1 && j < n2) {
            if (Compare.compare(leftArray[i], rightArray[j], parameterType) <= 0) {
                arr[k++] = leftArray[i++];
            } else {
                arr[k++] = rightArray[j++];
            }
        }
    }
}
