package castedo.dev.mymoneycheckback.user.application;

import castedo.dev.mymoneycheckback.user.application.ports.FindTokenPort;
import castedo.dev.mymoneycheckback.user.application.ports.SaveTokenPort;
import castedo.dev.mymoneycheckback.user.application.ports.UpdateTokenPort;
import castedo.dev.mymoneycheckback.user.dominio.Token;
import org.springframework.stereotype.Service;

@Service
public class TokenService {

    private final SaveTokenPort saveTokenPort;
    private final FindTokenPort findTokenPort;
    private final UpdateTokenPort updateTokenPort;

    public TokenService(SaveTokenPort saveTokenPort, FindTokenPort findTokenPort, UpdateTokenPort updateTokenPort) {
        this.saveTokenPort = saveTokenPort;
        this.findTokenPort = findTokenPort;
        this.updateTokenPort = updateTokenPort;
    }

    public void save(Token token){
        saveTokenPort.save(token);
    }

    public Token getToken(String token) {
        return findTokenPort.find(token);
    }

    public int setConfirmedAt(String token) {
        return updateTokenPort.confirmedAt(token);
    }

}
