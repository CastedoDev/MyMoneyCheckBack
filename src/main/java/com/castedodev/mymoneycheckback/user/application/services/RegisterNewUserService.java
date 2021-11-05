package com.castedodev.mymoneycheckback.user.application.services;

import com.castedodev.mymoneycheckback.user.application.ports.out.FindUserByEmailPort;
import com.castedodev.mymoneycheckback.user.application.ports.out.FindUserByUsernamePort;
import com.castedodev.mymoneycheckback.user.application.ports.out.SaveUserPort;
import com.castedodev.mymoneycheckback.user.domain.Usuario;
import org.springframework.stereotype.Service;

@Service
public class RegisterNewUserService {

    private final SaveUserPort savePort;
    private final FindUserByEmailPort findUserByEmailPort;
    private final FindUserByUsernamePort findUserByUsernamePort;

    public RegisterNewUserService(SaveUserPort savePort, FindUserByEmailPort findUserByEmailPort, FindUserByUsernamePort findUserByUsernamePort) {
        this.savePort = savePort;
        this.findUserByEmailPort = findUserByEmailPort;
        this.findUserByUsernamePort = findUserByUsernamePort;
    }

    public void invoke(Usuario usuario){

        if(findUserByUsernamePort.findByUsername(usuario.getUsername()).isPresent()){
            System.out.println("ERROR username");
        }

        if(findUserByEmailPort.findByEmail(usuario.getEmail()).isPresent()){
            System.out.println("ERROR email");
        }

        savePort.save(usuario);
    }
}
