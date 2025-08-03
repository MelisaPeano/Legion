package university.jala.capstonelegion.errors;

public class RuntimeParameterExceptionWithMessage extends Throwable {
    public RuntimeParameterExceptionWithMessage(String invalidParameters) {
        super(invalidParameters);
    }

}
