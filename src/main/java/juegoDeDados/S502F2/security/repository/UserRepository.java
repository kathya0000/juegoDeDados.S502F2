package juegoDeDados.S502F2.security.repository;


import juegoDeDados.S502F2.security.user.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Optional;

public interface UserRepository extends MongoRepository<User,Object> {

    Optional<User> findByEmail(String email);
}
