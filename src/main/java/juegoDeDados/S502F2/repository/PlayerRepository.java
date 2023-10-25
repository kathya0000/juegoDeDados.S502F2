package juegoDeDados.S502F2.repository;


import juegoDeDados.S502F2.models.Player;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;


@Repository
public interface PlayerRepository extends MongoRepository<Player, String> {

    Optional<Player> findPlayerByName(String name);
}
