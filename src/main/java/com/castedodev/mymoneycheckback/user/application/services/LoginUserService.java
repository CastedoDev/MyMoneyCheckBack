package com.castedodev.mymoneycheckback.user.application.services;

import com.castedodev.mymoneycheckback.user.application.ports.out.FindUserByEmailPort;
import com.castedodev.mymoneycheckback.user.application.ports.out.FindUserByUsernamePort;
import com.castedodev.mymoneycheckback.user.domain.Usuario;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class LoginUserService implements UserDetailsService {

    private final FindUserByUsernamePort findUserByUsernamePort;
    private final FindUserByEmailPort findUserByEmailPort;

    public LoginUserService(FindUserByUsernamePort findUserByUsernamePort, FindUserByEmailPort findUserByEmailPort) {
        this.findUserByUsernamePort = findUserByUsernamePort;
        this.findUserByEmailPort = findUserByEmailPort;
    }

    @Override
    public UserDetails loadUserByUsername(String identifier) throws UsernameNotFoundException {
        Optional<Usuario> userBD;
        if(identifier.indexOf('@') != -1){
            userBD = findUserByEmailPort.findByEmail(identifier);
            if(userBD.isPresent()){
                String usernameDB = userBD.get().getUsername();
                String emailDB = userBD.get().getEmail();
                String passwordDB = userBD.get().getPassword();
                if (emailDB.equals(identifier)) {
                    return new org.springframework.security.core.userdetails.User(usernameDB, passwordDB,
                            new ArrayList<>());
                } else {
                    throw new UsernameNotFoundException("User not found with email: " + identifier);
                }
            } else {
                throw new UsernameNotFoundException("User not found with email: " + identifier);
            }

        } else {
            userBD = findUserByUsernamePort.findByUsername(identifier);
            if(userBD.isPresent()) {
                String usernameDB = userBD.get().getUsername();
                String passwordDB = userBD.get().getPassword();
                if (usernameDB.equals(identifier)) {
                    return new User(usernameDB, passwordDB,
                            new ArrayList<>());
                } else {
                    throw new UsernameNotFoundException("User not found with username: " + identifier);
                }
            } else {
                throw new UsernameNotFoundException("User not found with username: " + identifier);
            }
        }

    }
}
