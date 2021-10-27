package com.castedodev.mymoneycheckback.user.application.ports.out;

import com.castedodev.mymoneycheckback.user.domain.User;

public interface SaveUserPort {

    void save(User user);
}
