package juegoDeDados.S502F2.exceptions;

import org.bson.types.ObjectId;

public class ElementNotFoundException extends RuntimeException {

    public ElementNotFoundException(Class<?> type, ObjectId id) {
        super(type.getSimpleName() + " with id " + id + " not found");
    }

    public ElementNotFoundException(Class<?> type, String key) {
        super(type.getSimpleName() + " with key " + key + " not found");
    }
}

