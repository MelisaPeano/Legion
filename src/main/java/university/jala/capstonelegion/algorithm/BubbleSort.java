package university.jala.capstonelegion.algorithm;

public class BubbleSort extends Compare {
    public Object[] orderByBubbleSort(Object[] orderArray, Object parameterType) {

        int allTroopsInArray = orderArray.length;
        for (int i = 0; i < allTroopsInArray - 1; i++) {
            for (int j = 0; j < allTroopsInArray - 1 - i; j++) {
                if (compare(orderArray[j], orderArray[j + 1], parameterType) > 0) {
                    Object objectTroop = orderArray[j];
                    orderArray[j] = orderArray[j + 1];
                    orderArray[j + 1] = objectTroop;
                }
            }
        }
      return orderArray;
    }
}
