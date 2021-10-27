package com.castedodev.mymoneycheckback.user.adapters.out.persistence;

import com.castedodev.mymoneycheckback.user.application.ports.out.FindUserByEmailPort;
import com.castedodev.mymoneycheckback.user.application.ports.out.FindUserByUsernamePort;
import com.castedodev.mymoneycheckback.user.application.ports.out.SaveUserPort;
import com.castedodev.mymoneycheckback.user.domain.User;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ImplPersistenceUser implements SaveUserPort, FindUserByUsernamePort, FindUserByEmailPort {

    private final UserRepository repository;

    public ImplPersistenceUser(UserRepository repository) {
        this.repository = repository;
    }

    public void save(User user){
        UserEntity userEntity = new UserEntity(user.getId(), user.getUsername(), user.getEmail(), user.getPassword());
        repository.save(userEntity);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        Optional<UserEntity> userToBeFound = repository.findByEmail(email);
        if(userToBeFound.isPresent()){
            UserEntity userFound = userToBeFound.get();
            User user = new User(userFound.getId(), userFound.getUsername(), userFound.getEmail(), userFound.getPassword());
            return Optional.of(user);
        }
        return Optional.empty();
    }

    @Override
    public Optional<User> findByUsername(String username) {
        Optional<UserEntity> userToBeFound = repository.findByUsername(username);
        if(userToBeFound.isPresent()){
            UserEntity userFound = userToBeFound.get();
            User user = new User(userFound.getId(), userFound.getUsername(), userFound.getEmail(), userFound.getPassword());
            return Optional.of(user);
        }
        return Optional.empty();
    }
}
