package juegoDeDados.S502F2.repository;

import juegoDeDados.S502F2.models.Game;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface GameRepository extends MongoRepository<Game, String> {

   List<Game> findAllByPlayerId(String id);

   List<Game> findGamesByPlayerId(String playerId);

}



