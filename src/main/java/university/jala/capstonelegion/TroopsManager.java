package university.jala.capstonelegion;

import university.jala.capstonelegion.enums.AlgorithmEnum;
import university.jala.capstonelegion.enums.OrientationType;
import university.jala.capstonelegion.enums.ParamsType;
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
    private final HashMap<String, Object> parameters;
    int[] arrayNumber;
    boolean invalidParameters = false;
    private AlgorithmEnum algorithm;
    private Object parameterType;
    private OrientationType orientation;
    private int units;
    private Object[][] matriz;
    private int rows;
    private int columns;
    private int speed;
    private String message;


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
        this.speed = 0;
        this.message = "";
    }

    public void play(String[] args) throws RuntimeParameterExceptionWithMessage {
        verifyParameters(args);
        if (processParameters()) {
            representationOfBattlefield();
            assignRandomTroops();
            orderByAlgorithm();
        }
    }

    /*
    Here could be better implement Strategy(VerifyParameters).
     */
    public void verifyParameters(String[] args) throws RuntimeParameterExceptionWithMessage {
        try {
            for (String arg : args) {
                String[] parts = arg.split("=");
                if (parts.length == 2) {
                    String key = parts[0];
                    String value = parts[1];
                    ParamsType paramsType = ParamsType.fromParam(key);
                    switch (paramsType) {
                        case ALGORITHM:
                            if (validator.isString(value)) {
                                String algorithm = value.toLowerCase();
                                switch (algorithm) {
                                    case "i" -> this.algorithm = AlgorithmEnum.INSERTION_SORT;
                                    case "m" -> this.algorithm = AlgorithmEnum.MERGE_SORT;
                                    case "b" -> this.algorithm = AlgorithmEnum.BUBBLE_SORT;
                                    case "q" -> this.algorithm = AlgorithmEnum.QUICK_SORT;
                                    default -> invalidParameters = true;
                                }
                                parameters.put("algorithm", algorithm);
                            } else {
                                invalidParameters = true;
                                System.out.println("[INVALID");
                                message = "INVALID PARAMETER FOR ALGORITHM(A)";
                            }
                            break;

                        case TYPE_OF_REPRESENTATION:
                            if (validator.isString(value)) {
                                this.parameterType = value.toLowerCase();
                                parameters.put("type", this.parameterType);
                            } else {
                                invalidParameters = true;
                                message = "INVALID PARAMETER FOR TYPE_OF_REPRESENTATION(T)";
                            }
                            break;

                        case NUMBER_OF_TROOPS:
                            this.arrayNumber = validator.isNumberArray(value);
                            if (arrayNumber != null) {
                                for (int j : arrayNumber) {
                                    units += j;
                                }
                                parameters.put("troops", units);
                            } else {
                                invalidParameters = true;
                                message = "INVALID PARAMETER FOR NUMBER_OF_TROOPS(T)";
                            }
                            break;
                        case NUMBER_OF_TROOPS2:
                            this.arrayNumber = validator.isNumberArray(value);
                            if (arrayNumber != null) {
                                for (int j : arrayNumber) {
                                    units += j;
                                }
                                parameters.put("troops", units);
                            } else {
                                invalidParameters = true;
                                message = "INVALID PARAMETER FOR NUMBER_OF_TROOPS(R)";
                            }
                            break;
                        case SIZE_OF_BATTLEFIELDS:
                            try {
                                int size = Integer.parseInt(value);
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
                                message = "INVALID PARAMETER FOR SIZE_OF_BATTLEFIELDS(F)";
                            }
                            break;
                        case ORIENTATION:
                            if (validator.isString(value)) {
                                switch (value.toLowerCase()) {
                                    case "n" -> this.orientation = OrientationType.SOUTH_TO_NORTH;
                                    case "s" -> this.orientation = OrientationType.NORTH_TO_SOUTH;
                                    case "w" -> this.orientation = OrientationType.EAST_TO_WEST;
                                    case "e" -> this.orientation = OrientationType.WEST_TO_EAST;
                                    default -> invalidParameters = true;
                                }
                                parameters.put("orientation", this.orientation);
                            } else {
                                invalidParameters = true;
                                message = "INVALID PARAMETER FOR ORIENTATION(o)";
                            }
                            break;
                        case SPEED:
                            try {
                                int speed = Integer.parseInt(value);
                                if (speed < 10000) {
                                    this.speed = speed;
                                    parameters.put("speed", value);
                                }
                                if (speed < 0) {
                                    this.speed = 100;
                                }
                            } catch (NumberFormatException e) {
                                invalidParameters = true;
                                message = "INVALID PARAMETER FOR SPEED(s)";
                            }
                            break;
                    }
                }

            }
        } catch (RuntimeParameterException e) {
            invalidParameters = true;
            throw new RuntimeParameterExceptionWithMessage(e.getMessage());
        }
    }

    public boolean processParameters() {
        if (invalidParameters) {
            System.out.println("Algorithm: [INVALID]");
            System.out.println("Type: [INVALID]");
            System.out.println("Troops: [INVALID]");
            System.out.println("Orientation: [INVALID]");
            System.out.println("Speed: [INVALID]");
            System.out.println("\nInvalid parameters: What's wrong? : " + message);
            return false;
        } else {
            return true;
        }
    }

    public void assignRandomTroops() {
        List<Object> temporaryList = new ArrayList<>();

        for (int i = 0; i < rows; i++) {
            temporaryList.addAll(Arrays.asList(matriz[i]).subList(0, columns));
        }
        Collections.shuffle(temporaryList);

        int index = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matriz[i][j] = temporaryList.get(index++);
            }
        }
        printManager.print(matriz, parameterType);
    }

    public void representationOfBattlefield() {

        HashMap<String, Object> valParameters = validator.hashValidation(this.parameters);
        int number = (int) valParameters.get("Battlefield");

        String algorithmName = this.algorithm.getName();
        if (!(algorithmName == null)) {
            for (String key : valParameters.keySet()) {
                if (key.equals("troops")) {
                    System.out.println("Troops: [" + valParameters.get(key) + "]\n");
                } else if (key.equals("type") && valParameters.get("type").equals("c")) {
                    System.out.println("Type: [Character]");
                } else if (key.equals("type") && valParameters.get("type").equals("n")) {
                    System.out.println("Type: [Number]");
                } else if (key.equals("algorithm")) {
                    System.out.println("Algorithm: [" + algorithmName + "]");
                } else if (key.equals("orientation")) {
                    System.out.println("\nOrientation: [" + orientation + "]");
                } else if (key.equals("Battlefield")) {
                    System.out.println("Battlefield: [" + valParameters.get(key) + "]");
                } else if (key.equals("speed")) {
                    System.out.println("Speed: [" + valParameters.get(key) + "]");
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

    public void orderByAlgorithm() {
        if (this.algorithm != null) {
            this.matriz = troopOrdering.prepareToOrder(
                    algorithm,
                    rows,
                    columns,
                    matriz,
                    parameterType,
                    orientation.getOrientation(),
                    speed);
        } else {
            invalidParameters = true;
            System.out.println("[Invalid]");
        }
        printManager.print(this.matriz, parameterType);
    }
}

