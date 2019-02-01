package pl.lukabrasi.weatheronline.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.lukabrasi.weatheronline.entities.UserEntity;
import pl.lukabrasi.weatheronline.repositories.UserRepository;

import java.util.Optional;

@Service
public class UserService {

    final UserRepository userRepository;

    @Autowired

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean addUser(String login, String password, String email) {
        UserEntity userEntity = new UserEntity();
        userEntity.setLogin(login);
        userEntity.setPassword(password);
        userEntity.setEmail(email);

        if (userRepository.existsByLogin(login)) {
            return false;
        }
        return userRepository.save(userEntity) != null;
    }

    public boolean tryLogin(String login, String password) {
        Optional<UserEntity> userEntity = userRepository.findByLoginAndPassword(login, password);


        return userEntity.isPresent();
    }
}