package juegoDeDados.S502F2.exceptions;

public class ElementAlreadyExistsException extends RuntimeException {

    public ElementAlreadyExistsException(Class type, String name) {
        super("Element of " + type.getSimpleName() + " with name " + name + " already exists");
    }
}