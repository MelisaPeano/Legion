package university.jala.capstonelegion;
/*
• Validar posiciones válidas en el campo.
• Validar que las tropas no excedan el campo de batalla.
• Manejar errores de entrada del usuario.
• Validar que las diferentes unidades no se mezclen.
 */

// Maps para validación de parámetros
// Asegurar un manejo adecuado de errores y situaciones inesperadas.
//• Control de argumentos.

import university.jala.capstonelegion.errors.RuntimeParameterExceptionWithMessage;

public class Validator {
    public void validator() {}

    public boolean isString(String string) throws RuntimeParameterExceptionWithMessage {
        if (!string.matches("[a-zA-Z]+")) {
            throw new RuntimeParameterExceptionWithMessage("'a' must contain only alphanumeric characters");
        } else {
            return true;
        }
    }

    public int[] isNumberArray(String string) throws RuntimeParameterExceptionWithMessage {
        String[] numbers = string.split(",");
        for (String number : numbers) {
            try {
                Integer.parseInt(number.trim());
                int [] numberArray = new int[numbers.length];
                for (int i = 0; i < numberArray.length; i++) {
                    numberArray[i] = Integer.parseInt(number);
                }
                return numberArray;
            } catch (NumberFormatException e) {
                throw new RuntimeParameterExceptionWithMessage("All elements must be numeros");
            }
        }
        return null;
    }
}
