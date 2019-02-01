package pl.lukabrasi.weatheronline.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.lukabrasi.weatheronline.entities.UserEntity;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Integer> {

    boolean existsByLogin(String login);
    boolean existsByLoginAndPassword(String login, String password);
    Optional<UserEntity> findByLoginAndPassword(String login, String password);
}
