package university.jala.capstonelegion;

import java.util.HashMap;

public class Validator {

    public boolean isString(String string) {
        return string.matches("[a-zA-Z]+");
    }

    public int[] isNumberArray(String string) {
        try {
            String[] parts = string.split(",");
            int[] result = new int[parts.length];
            for (int i = 0; i < parts.length; i++) {
                result[i] = Integer.parseInt(parts[i].trim());
            }
            return result;
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public HashMap<String, Object> hashValidation(HashMap<String, Object> hashMap) {
        if (!hashMap.containsKey("Battlefield")) {
            hashMap.put("Battlefield", 6);
            System.out.println("Battlefield: " + "[" + 6 + "x" + 6 + "] \n");
        }
        return hashMap;
    }


}
