package juegoDeDados.S502F2.exceptions;

import juegoDeDados.S502F2.models.Player;
import org.bson.types.ObjectId;

public class ElementsDoesntEqualsException extends RuntimeException{

    public ElementsDoesntEqualsException(Class type, ObjectId id, ObjectId idDto) {
        super("Id's in " + type.getSimpleName() + " must be equals. Entered values " + id + " - "+ idDto);
    }

    public ElementsDoesntEqualsException(Class<Player> type, String id, String id1) {
    }
}
