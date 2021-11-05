package com.castedodev.mymoneycheckback.user.application.services;

import com.castedodev.mymoneycheckback.user.application.ports.out.FindUserByEmailPort;
import com.castedodev.mymoneycheckback.user.application.ports.out.FindUserByUsernamePort;
import com.castedodev.mymoneycheckback.user.domain.User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FindUser {

    private final FindUserByUsernamePort findUserByUsernamePort;
    private final FindUserByEmailPort findUserByEmailPort;

    public FindUser(FindUserByUsernamePort findUserByUsernamePort, FindUserByEmailPort findUserByEmailPort) {
        this.findUserByUsernamePort = findUserByUsernamePort;
        this.findUserByEmailPort = findUserByEmailPort;
    }

    public Optional<User> find(String identifier){
        Optional<User> optUser = findUserByEmailPort.findByEmail(identifier);
        if(optUser.isPresent()){
           return optUser;
        } else {
            return findUserByUsernamePort.findByUsername(identifier);
        }
    }

}
