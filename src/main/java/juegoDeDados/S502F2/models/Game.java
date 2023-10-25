package juegoDeDados.S502F2.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection= "game")
public class Game {
    @Id
    private String Id;
    private Integer points;
    private String playerId;

    public Game(String playerId, Integer points) {
        this.playerId = playerId;
        this.points = points;
    }

    @Override
    public String toString() {
        return playerId  +
                "You've got " + points + " points " + " " +
                ((points == 7) ? " You WIN!!!!" : " You LOST!!!")
                + "\n";

    }
}

