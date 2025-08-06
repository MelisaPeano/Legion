package university.jala.capstonelegion;

import university.jala.capstonelegion.enums.AlgorithmEnum;
import university.jala.capstonelegion.errors.RuntimeParameterException;
import university.jala.capstonelegion.errors.RuntimeParameterExceptionWithMessage;
import university.jala.capstonelegion.players.CharacterFactory;
import university.jala.capstonelegion.players.GameCharacter;
import university.jala.capstonelegion.printer.PrintManager;

import java.util.*;

public class TroopsManager {

    private final Validator validator;
    private final PrintManager printManager;
    private final CharacterFactory characterFactory;
    private final TroopOrdering troopOrdering;

   // private List<Troops> troops;
    private AlgorithmEnum algorithm;
    private Object parameterType;
  //  private String orientation;
    private int units;
    private Object[][] matriz;
    private int rows;
    private int columns;
    private HashMap<String, Object> parameters;


    public TroopsManager() {
        this.characterFactory = new CharacterFactory();
        // this.troops = null;
        this.algorithm = null;
        this.parameterType = null;
        // this.orientation = null;
        this.units = 0;
        this.matriz = null;
        this.printManager = new PrintManager();
        this.validator = new Validator();
        this.troopOrdering = new TroopOrdering();
        this.parameters = new HashMap<>();

    }

    int[] arrayNumber;
    boolean invalidParameters = false;

    public void VerifyParameters(String[] args) throws RuntimeParameterExceptionWithMessage {
        try {
            for (String arg : args) {
                String[] parts = arg.split("=");
                if (parts.length == 2) {
                    String key = parts[0];
                    String value = parts[1];

                    switch (key) {
                        case "a":
                            if (validator.isString(value)) {

                                String algorithm = value.toLowerCase();
                                switch (algorithm) {
                                    case "i" -> this.algorithm = AlgorithmEnum.INSERTION_SORT;
                                    case "s" -> this.algorithm = AlgorithmEnum.SORT;
                                    case "b" -> this.algorithm = AlgorithmEnum.BUBBLE_SORT;
                                }
                                parameters.put("algorithm", algorithm);
                            } else {
                                invalidParameters = true;
                                System.out.println("[INVALID");
                            }
                            break;

                        case "t":
                            if (validator.isString(value)) {
                                this.parameterType = value.toLowerCase();
                                parameters.put("type", value);
                            } else {
                                invalidParameters = true;
                                System.out.println("[INVALID]");
                            }
                            break;

                        case "u":
                            this.arrayNumber = validator.isNumberArray(value);
                            if (arrayNumber != null) {
                                for (int j : arrayNumber) {
                                    units += j;
                                }
                                parameters.put("troops ", units);
                            } else {
                                invalidParameters = true;
                                System.out.println("[INVALID");
                            }
                            break;
                        case "r":
                            this.arrayNumber = validator.isNumberArray(value);
                            if (arrayNumber != null) {
                                for (int j : arrayNumber) {
                                    units += j;
                                }
                                parameters.put("troops:", units);
                            } else {
                                invalidParameters = true;
                                System.out.println("[INVALID");
                            }
                            break;
                        case "f":
                            try {
                                int size = Integer.parseInt(value);

                                if (size == 0) {
                                    parameters.put("Battlefield", 6);
                                }

                                if (size > 5 && size < 1000) {
                                    this.rows = size;
                                    this.columns = size;
                                } else {
                                    this.rows = 6;
                                    this.columns = 6;
                                }
                                parameters.put("Battlefield", rows);
                            } catch (NumberFormatException e) {
                                invalidParameters = true;
                            }
                            break;

                    }
                }

            }
        } catch (RuntimeParameterException e) {
            System.out.println("Algorithm: [INVALID]");
            System.out.println("Type: [INVALID]");
            System.out.println("Troops: [INVALID]");
            System.out.println("\nInvalid parameters:");
            throw new RuntimeParameterExceptionWithMessage(e.getMessage());
        }
    }

    public boolean ProcessParameters() {
        if (invalidParameters) {
            System.out.println("Algorithm: [INVALID]");
            System.out.println("Type: [INVALID]");
            System.out.println("Troops: [INVALID]");
            System.out.println("\nInvalid parameters:");
            return false;
        } else {
            return true;
        }
    }

    public void AssignRandomTroops() {
        List<Object> lista = new ArrayList<>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                lista.add(matriz[i][j]);
            }
        }
        Collections.shuffle(lista);

        int index = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matriz[i][j] = lista.get(index++);
            }
        }
        printManager.print(matriz,parameterType);
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

        HashMap<String, Object> valParameters = validator.hashValidation(this.parameters);
        int number = (int) valParameters.get("Battlefield");

        String algorithmName = this.algorithm.getName();

        for (String key : valParameters.keySet()) {
            if (key.equals("troops")) {
                System.out.println("Troops: [" + (int) valParameters.get(key) + "]\n");
            } else if (key.equals("type") && valParameters.get("type").equals("c")) {
                System.out.println("Type: [Character] \n");
            } else if (key.equals("type") && valParameters.get("type").equals("n"))  {
                System.out.println("Type: [Number] \n");
            } else if (key.equals("algorithm")) {
                System.out.println("Algorithm: [" + algorithmName + "]" );
            }

        }
        System.out.println("\nInitial Position:\n");

        this.rows = number;
        this.columns = number;

        this.matriz = new Object[number][number];

        List<GameCharacter> characters = characterFactory.createCharacter(this.arrayNumber);

        int index = 0;
        for (int i = 0; i < rows && index < characters.size(); i++) {
            for (int j = 0; j < columns && index < characters.size(); j++) {
                matriz[i][j] = characters.get(index++);
            }
        }

    }

    public void OrderByAlgorithm() {
        switch (this.algorithm) {
            case INSERTION_SORT -> {
                System.out.println("\nOrdenando con Insertion Sort...\n");
                this.matriz = troopOrdering.orderByInsertion(rows, columns, matriz,parameterType);
            }
            case HEAP_SORT -> System.out.println("Heap sort");
            case QUICK_SORT -> System.out.println("Quick sort");
            case MERGE_SORT -> System.out.println("Merge sort");
            case BUBBLE_SORT -> System.out.println("Bubble sort");
            case CURTING_SORT -> System.out.println("Curting sort");
            case RADIX_SORT -> System.out.println("Radix sort");
            case SORT -> System.out.println("Sort");
            default -> throw new RuntimeParameterException();

        }
        printManager.print(this.matriz, parameterType);
    }

}

