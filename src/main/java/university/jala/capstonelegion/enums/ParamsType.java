package university.jala.capstonelegion.enums;

public enum ParamsType {
    ALGORITHM("a"),
    ORIENTATION("o"),
    TYPE_OF_REPRESENTATION("t"),
    NUMBER_OF_TROOPS("u"),
    NUMBER_OF_TROOPS2("r"),
    SIZE_OF_BATTLEFIELDS("f");

    private final String param;

    ParamsType(String param) {
        this.param = param;
    }

    public static ParamsType fromParam(String param) {
        for (ParamsType paramType : values()) {
            if (paramType.param.equalsIgnoreCase(param)) {
                return paramType;
            }
        }
        throw new IllegalArgumentException("Algoritmo desconocido: " + param);
    }

}
