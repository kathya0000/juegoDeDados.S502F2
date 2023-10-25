package juegoDeDados.S502F2.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import juegoDeDados.S502F2.models.Player;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;

import java.io.Serializable;

@AllArgsConstructor
@Setter
@Getter
public class GameDTO implements Serializable {

    private String id;
    private Integer points;
    private String playerId;

    @Override
    public String toString() {
        return  "id=" + id +
                ", points=" + points +
                ", player: " + playerId ;
    }
}
