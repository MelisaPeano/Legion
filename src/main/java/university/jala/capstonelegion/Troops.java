package university.jala.capstonelegion;

import university.jala.capstonelegion.errors.RuntimeParameterExceptionWithMessage;
/*
Facade
 */
public class Troops {
    public static void main(String[] args) throws RuntimeParameterExceptionWithMessage {
        TroopsManager troopsManager = new TroopsManager();
        troopsManager.play(args);
    }
}


// agregar impresion para los demás algoritmos
// sumar el parámetro s
// agregar el conteo de tiempo.