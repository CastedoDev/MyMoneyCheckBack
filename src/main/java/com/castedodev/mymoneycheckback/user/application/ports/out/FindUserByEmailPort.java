package com.castedodev.mymoneycheckback.user.application.ports.out;

import com.castedodev.mymoneycheckback.user.domain.User;

import java.util.Optional;

public interface FindUserByEmailPort {

    Optional<User> findByEmail(String email);

}
