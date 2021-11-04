package com.castedodev.mymoneycheckback.user.application.ports.out;

import com.castedodev.mymoneycheckback.user.domain.Usuario;

public interface SaveUserPort {

    void save(Usuario usuario);
}
