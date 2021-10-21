package castedo.dev.mymoneycheckback.user.application.ports;

import castedo.dev.mymoneycheckback.user.dominio.Token;

public interface SaveTokenPort {

     void save(Token token);
}
