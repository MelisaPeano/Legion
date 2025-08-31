package university.jala.capstonelegion.algorithm;

import university.jala.capstonelegion.enums.ParamsType;

public class Insertion extends Compare {
    public Object[] orderByInsertion(Object[] orderArray, Object type) {

        for (int i = 1; i < orderArray.length; i++) {
            Object troop = orderArray[i];
            int j = i - 1;

            while (j >= 0 && compare(orderArray[j], troop, type) > 0) {
                orderArray[j + 1] = orderArray[j];
                j--;
            }
            orderArray[j + 1] = troop;
        }
        return orderArray;
    }
}
