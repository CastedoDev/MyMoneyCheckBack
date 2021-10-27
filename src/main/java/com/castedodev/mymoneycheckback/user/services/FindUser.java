package com.castedodev.mymoneycheckback.user.services;

import com.castedodev.mymoneycheckback.user.application.ports.out.FindUserByEmailPort;
import com.castedodev.mymoneycheckback.user.application.ports.out.FindUserByUsernamePort;
import org.springframework.stereotype.Service;

@Service
public class FindUser {

    private final FindUserByUsernamePort findUserByUsernamePort;
    private final FindUserByEmailPort findUserByEmailPort;

    public FindUser(FindUserByUsernamePort findUserByUsernamePort, FindUserByEmailPort findUserByEmailPort) {
        this.findUserByUsernamePort = findUserByUsernamePort;
        this.findUserByEmailPort = findUserByEmailPort;
    }


}
