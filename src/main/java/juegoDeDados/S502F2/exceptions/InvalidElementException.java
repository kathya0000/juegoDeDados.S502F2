package juegoDeDados.S502F2.exceptions;

public class InvalidElementException extends RuntimeException{

    public InvalidElementException(Class type) {
        super("Id from " + type.getSimpleName() + " is invalid");
    }
}
