package university.jala.capstonelegion;

import university.jala.capstonelegion.enums.AlgorithmEnum;
import university.jala.capstonelegion.errors.RuntimeParameterException;
import university.jala.capstonelegion.errors.RuntimeParameterExceptionWithMessage;
import university.jala.capstonelegion.players.Character;
import university.jala.capstonelegion.players.CharacterFactory;
import university.jala.capstonelegion.printer.PrintManager;

import java.util.*;

public class TroopsManager {

    private final Validator validator;
    private final PrintManager printManager;

    private List<Troops> troops;
    private AlgorithmEnum algorithm;
    private Object parameterType;
    private String orientation;
    private int[] units;
    private Object[][] matriz;
    private int rows;
    private int columns;


    public TroopsManager() {
        this.troops = null;
        this.algorithm = null;
        this.parameterType = null;
        this.orientation = null;
        this.units = null;
        this.matriz = null;
        this.printManager = new PrintManager();
        this.validator = new Validator();

    }
    public void processParameters(String[] args)  {
        Map<String, String> parameters = new HashMap<>();

        for (String arg : args) {
            String[] parts = arg.split("=");
            if (parts.length == 2) {
                String key = parts[0];
                String value = parts[1];
                parameters.put(key, value);

                switch (key) {
                    case "a":
                        try {
                            if(validator.isString(value)) {
                               for(AlgorithmEnum algorithm : AlgorithmEnum.values()) {
                                   if(Objects.equals(algorithm.getSymbol(), value) || Objects.equals(algorithm.getSymbol2(), value)) {
                                       this.algorithm = algorithm;
                                   }
                               }
                            } else {
                                throw new RuntimeParameterException();
                            }
                        } catch (RuntimeParameterExceptionWithMessage e) {
                            throw new RuntimeException(e);
                        }
                        break;
                    case "t":
                        try {
                            if (validator.isString(value)) {
                                this.parameterType = value;
                                if(value.equals("c")) {
                                    printManager.printFieldWithStrings(this.matriz);
                                } else if(value.equals("n")) {
                                    printManager.printFieldWithNumbers(this.matriz);
                                }
                            } else {
                                throw new RuntimeParameterException();
                            }
                        } catch (RuntimeParameterExceptionWithMessage e) {
                            throw new RuntimeException(e);
                        }
                        break;
                    case "f":
                        try {
                            if(validator.isString(value)) {
                                String[] values = value.split("(?i)x");
                                int rows = Integer.parseInt(values[0]);
                                int columns = Integer.parseInt(values[1]);
                                if (rows > 5 && rows < 1000 && columns > 5 && columns < 1000) {
                                    rows = rows;
                                    columns = columns;
                                } else {
                                    rows = 10;
                                    columns = 10;
                                }
                            }
                        } catch (RuntimeParameterExceptionWithMessage e) {
                            throw new RuntimeException(e);
                        }
                        break;
                    case "u":
                        try {
                            int [] arrayNumber = validator.isNumberArray(value);
                            if(arrayNumber != null ){
                                representationOfBattlefield(arrayNumber);
                            }
                        } catch (RuntimeParameterExceptionWithMessage e) {
                            throw new RuntimeException(e);
                        }
                }
            } else {
                try {
                    throw new RuntimeParameterExceptionWithMessage("Invalid Parameters");
                } catch (RuntimeParameterExceptionWithMessage e) {
                    throw new RuntimeException(e);
                }
            }
        }
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

    public void representationOfBattlefield(int[] arrayNumber) {
        matriz = new Object[rows][columns];

        List<Character> characters = CharacterFactory(int[] arrayNumber);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {

            }
        }

        /*
        Representación Interna del Campo:
        Se debe crear una estructura interna del campo de batalla en el programa
         (una matriz, lista o mapa), donde se registren las tropas y sus posiciones.
         */
    }


}
