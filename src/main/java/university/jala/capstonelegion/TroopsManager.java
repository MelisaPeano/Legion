package university.jala.capstonelegion;

import java.util.ArrayList;
import java.util.List;

public class TroopsManager {

    private List<Troops> troops;

    public TroopsManager() {
        this.troops = new ArrayList<>();
    }

    public void AssignRandomTroops(){
        /*
        Se seleccionarán aleatoriamente unidades del conjunto disponible de
        tipos de tropas (por ejemplo: comandante, médico, infantería, y
        otros elementos relacionados, según lo definido en el proyecto),
        hasta alcanzar las cantidades indicadas por el parámetro r.
        Esta selección debe hacerse mediante un generador de números aleatorios.
         */
    }

    public void battlefieldRestriction() {
        /*
        a) Puede haber múltiples soldados de infantería, médicos o comandantes,
        pero limitados según las dimensiones del campo (f) y el número de tropas (r).
        b) No se debe exceder la cantidad total de casillas disponibles (f x f) sabiendo que
        cada tipo de unidad tiene que estar en una línea distinta.
        Ubicación Aleatoria en el Campo:
        Cada tropa debe ser colocada en una posición aleatoria dentro del campo de batalla,
        representado por una matriz cuadrada de tamaño f x f.
        Evitar Conflictos de Posición:
        El sistema debe validar que no haya dos tropas ocupando la misma casilla.
        En caso de conflicto, se deberá intentar con una nueva posición aleatoria.
         */
    }

    public void representationOfBattlefield() {
        /*
        Representación Interna del Campo:
        Se debe crear una estructura interna del campo de batalla en el programa
         (una matriz, lista o mapa), donde se registren las tropas y sus posiciones.
         */
    }
   // private final ParamProcessor processor;
   // private final Validator validator;
   // private final Calculator calculator;
   // private final PrintManager printManager;

}
