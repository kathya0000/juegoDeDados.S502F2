package juegoDeDados.S502F2.service;

import juegoDeDados.S502F2.dto.PlayerDTO;
import juegoDeDados.S502F2.models.Player;
import org.bson.types.ObjectId;

public interface PlayerService {

    PlayerDTO createPlayer(PlayerDTO playerDTO);

    Object updatePlayer(String id, PlayerDTO playerDTO);

    Player getPlayerById(String id);

}
