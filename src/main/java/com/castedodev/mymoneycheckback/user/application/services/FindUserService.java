package com.castedodev.mymoneycheckback.user.application.services;

import com.castedodev.mymoneycheckback.user.application.ports.out.FindUserByEmailPort;
import com.castedodev.mymoneycheckback.user.application.ports.out.FindUserByUsernamePort;
import com.castedodev.mymoneycheckback.user.domain.NotUserFound;
import com.castedodev.mymoneycheckback.user.domain.Usuario;
import org.springframework.stereotype.Service;

@Service
public class FindUserService {

    private final FindUserByUsernamePort findUserByUsernamePort;
    private final FindUserByEmailPort findUserByEmailPort;

    public FindUserService(FindUserByUsernamePort findUserByUsernamePort, FindUserByEmailPort findUserByEmailPort) {
        this.findUserByUsernamePort = findUserByUsernamePort;
        this.findUserByEmailPort = findUserByEmailPort;
    }

    public Usuario findByUsername(String username) throws NotUserFound {
        return findUserByUsernamePort.findByUsername(username).orElseThrow(NotUserFound::new);
    }


}
