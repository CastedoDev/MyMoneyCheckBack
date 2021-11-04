package com.castedodev.mymoneycheckback.user.adapters.out.persistence;

import com.castedodev.mymoneycheckback.user.application.ports.out.FindUserByEmailPort;
import com.castedodev.mymoneycheckback.user.application.ports.out.FindUserByUsernamePort;
import com.castedodev.mymoneycheckback.user.application.ports.out.SaveUserPort;
import com.castedodev.mymoneycheckback.user.domain.Usuario;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ImplPersistenceUser implements SaveUserPort, FindUserByUsernamePort, FindUserByEmailPort {

    private final UserRepository repository;

    public ImplPersistenceUser(UserRepository repository) {
        this.repository = repository;
    }

    public void save(Usuario usuario){
        UserEntity userEntity = new UserEntity(usuario.getId(), usuario.getUsername(), usuario.getEmail(), usuario.getPassword());
        repository.save(userEntity);
    }

    @Override
    public Optional<Usuario> findByEmail(String email) {
        Optional<UserEntity> userToBeFound = repository.findByEmail(email);
        if(userToBeFound.isPresent()){
            UserEntity userFound = userToBeFound.get();
            Usuario usuario = new Usuario(userFound.getId(), userFound.getUsername(), userFound.getEmail(), userFound.getPassword());
            return Optional.of(usuario);
        }
        return Optional.empty();
    }

    @Override
    public Optional<Usuario> findByUsername(String username) {
        Optional<UserEntity> userToBeFound = repository.findByUsername(username);
        if(userToBeFound.isPresent()){
            UserEntity userFound = userToBeFound.get();
            Usuario usuario = new Usuario(userFound.getId(), userFound.getUsername(), userFound.getEmail(), userFound.getPassword());
            return Optional.of(usuario);
        }
        return Optional.empty();
    }
}
