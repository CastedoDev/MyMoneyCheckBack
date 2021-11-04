package com.castedodev.mymoneycheckback.user.application.ports.out;

import com.castedodev.mymoneycheckback.user.domain.Usuario;

import java.util.Optional;

public interface FindUserByUsernamePort {

    Optional<Usuario> findByUsername(String username);

}
