package castedo.dev.mymoneycheckback.user.application.ports;

import castedo.dev.mymoneycheckback.user.dominio.Token;

import java.util.Optional;

public interface FindTokenPort {

    Token find(String token);

}
