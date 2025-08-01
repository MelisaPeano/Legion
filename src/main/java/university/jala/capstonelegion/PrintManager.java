package university.jala.capstonelegion;

import java.util.List;
/*
Muestra visual del campo de batalla una al principio y al final del ordenamiento.
 */

public class PrintManager {

    public PrintManager() {

    }

    public void printFieldOfGame(List<Troops> troops) {
      int [][] fielOfWars = new int[troops.size()][];
        for (Troops troop : troops) {
            System.out.println(troop);
        }
    }
}
