package university.jala.capstonelegion.errors;

public class RuntimeParameterException extends RuntimeException {
    public RuntimeParameterException() {
        super();
        throw new IllegalArgumentException("[Invalid");
    }

}
