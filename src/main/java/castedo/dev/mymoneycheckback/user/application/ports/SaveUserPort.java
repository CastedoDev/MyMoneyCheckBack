package castedo.dev.mymoneycheckback.user.application.ports;

import castedo.dev.mymoneycheckback.user.dominio.User;

public interface SaveUserPort {

    void save(User user);
}
