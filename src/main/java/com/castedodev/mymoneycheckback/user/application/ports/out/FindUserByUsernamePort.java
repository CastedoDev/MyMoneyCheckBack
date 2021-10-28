package com.castedodev.mymoneycheckback.user.application.ports.out;

import com.castedodev.mymoneycheckback.user.domain.User;

import java.util.Optional;

public interface FindUserByUsernamePort {

    Optional<User> findByUsername(String username);

}
