package university.jala.capstonelegion;

import university.jala.capstonelegion.enums.AlgorithmEnum;
import university.jala.capstonelegion.enums.OrientationType;
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


    private AlgorithmEnum algorithm;
    private Object parameterType;
    private OrientationType orientation;
    private int units;
    private Object[][] matriz;
    private int rows;
    private int columns;
    private HashMap<String, Object> parameters;


    public TroopsManager() {
        this.characterFactory = new CharacterFactory();
        this.algorithm = null;
        this.parameterType = null;
        this.orientation = null;
        this.units = 0;
        this.matriz = null;
        this.printManager = new PrintManager();
        this.validator = new Validator();
        this.troopOrdering = new TroopOrdering();
        this.parameters = new HashMap<>();

    }

    int[] arrayNumber;
    boolean invalidParameters = false;

    public void verifyParameters(String[] args) throws RuntimeParameterExceptionWithMessage {
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
                                    case "h" -> this.algorithm = AlgorithmEnum.HEAP_SORT;

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
                                    this.rows = 10;
                                    this.columns = 10;
                                }
                                parameters.put("Battlefield", rows);
                            } catch (NumberFormatException e) {
                                invalidParameters = true;
                            }
                            break;
                        case "o":
                            if (validator.isString(value)) {
                                switch (value.toLowerCase()) {
                                    case "n" -> this.orientation = OrientationType.SOUTH_TO_NORTH;
                                    case "s" -> this.orientation = OrientationType.NORTH_TO_SOUTH;
                                    case "w" -> this.orientation = OrientationType.EAST_TO_WEST;
                                    case "e" -> this.orientation = OrientationType.WEST_TO_EAST;
                                }
                                parameters.put("orientation", this.orientation);
                            }

                    }
                }

            }
        } catch (RuntimeParameterException e) {
            System.out.println("Algorithm: [INVALID]");
            System.out.println("Type: [INVALID]");
            System.out.println("Troops: [INVALID]");
            System.out.println("Orientation: [INVALID]");
            System.out.println("\nInvalid parameters:");
            throw new RuntimeParameterExceptionWithMessage(e.getMessage());
        }
    }

    public boolean processParameters() {
        if (invalidParameters) {
            System.out.println("Algorithm: [INVALID]");
            System.out.println("Type: [INVALID]");
            System.out.println("Troops: [INVALID]");
            System.out.println("Orientation: [INVALID]");
            System.out.println("\nInvalid parameters:");
            return false;
        } else {
            return true;
        }
    }

    public void assignRandomTroops() {
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

    public void representationOfBattlefield() {

        HashMap<String, Object> valParameters = validator.hashValidation(this.parameters);
        int number = (int) valParameters.get("Battlefield");

        String algorithmName = this.algorithm.getName();
        if (!(algorithmName == null)) {
            for (String key : valParameters.keySet()) {
                if (key.equals("troops")) {
                    System.out.println("Troops: [" + (int) valParameters.get(key) + "]\n");
                } else if (key.equals("type") && valParameters.get("type").equals("c")) {
                    System.out.println("Type: [Character]");
                } else if (key.equals("type") && valParameters.get("type").equals("n"))  {
                    System.out.println("Type: [Number]");
                } else if (key.equals("algorithm")) {
                    System.out.println("Algorithm: [" + algorithmName + "]" );
                } else if (key.equals("orientation")) {
                    System.out.println("\nOrientation: [" + orientation + "]" );
                } else if (key.equals("Battlefield")) {
                    System.out.println("Battlefield: [" + (int) valParameters.get(key) + "]" );
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
        } else {
            invalidParameters = true;
        }

    }
    /*
        The algorithm discussed will be implemented in the future.
        (@Link: orderByAlgorithm)
            MERGE_SORT
     */

    public void orderByAlgorithm() {
        switch (this.algorithm) {
            case INSERTION_SORT -> {
                System.out.println("\nOrdering Insertion Sort...\n");
                this.matriz = troopOrdering.orderByInsertion(
                        rows,
                        columns,
                        matriz,
                        parameterType,
                        orientation.getOrientation());
            }
            case BUBBLE_SORT ->{
                System.out.println("\nOrdering by Bubble Sort...\n");
                this.matriz = troopOrdering.orderByBubbleSort(
                        rows,
                        columns,
                        matriz,
                        parameterType,
                        orientation.getOrientation());
            }
            case HEAP_SORT -> {
                System.out.println("\nOrdering by Heap sort...\n");
                troopOrdering.orderByHeapSort(
                        rows,
                        columns,
                        matriz,
                        parameterType,
                        orientation.getOrientation());
            }
            default -> {
                this.algorithm = null;
                System.out.println("[Invalid]");
            }

        }
        printManager.print(this.matriz, parameterType);
    }

}

