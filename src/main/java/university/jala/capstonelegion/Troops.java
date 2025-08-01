package university.jala.capstonelegion;

public class Troops {
    public static void main(String[] args) {
        TroopsManager troopsManager = new TroopsManager();
        troopsManager.processParameters(args);
        // Validar tipo y unidades,a = valor
        // a=i(algoritmo) t=c/n(tipo de parametro) o=n(de arriba a abajo) u=1,2,3,4,5 r=

        /*
        parametro f = tamaño del campo de batalla NXN
        N es un número entero positivo mayor o igual a 5 y menor
        o igual a 1000 (por defecto, se usa 10 si no se especifica).
        El parámetro r (o u en ejemplos posteriores) especifica cuántas unidades
        de cada tipo se desplegarán. Es una lista separada por comas, donde cada
        posición representa un tipo de tropa.
        Esto se traduce como:

            1 Comandante

            2 Médicos

            4 Tanques

            7 Snipers

            8 Infantería

            Este total no debe exceder el tamaño del campo (f x f),
            ni puede haber superposición entre tipos de tropas.
         */

        boolean validParameters = troopsManager.validateParameters();
        if (validParameters) {
            // if parameters are valid
        }

        // TroopsManager.displayOutput()
    }
}
/*Requisitos del Proyecto
 Modelado de tropas con clases e interfaces.
 Implementación de ordenamientos por atributos personalizables.
 Visualización del campo de batalla.
 Parámetros CLI para entrada del usuario.
 Cronometrar el tiempo de ejecución del ordenamiento.
 Código documentado + diagrama UML.
 Git con historial de cambios.
*  */