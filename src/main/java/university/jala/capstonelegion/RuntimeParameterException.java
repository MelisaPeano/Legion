package university.jala.capstonelegion;

public class RuntimeParameterException extends RuntimeException {
    public RuntimeParameterException(String message) {
        super(message);
        throw new IllegalArgumentException("[Invalid");
    }
}
