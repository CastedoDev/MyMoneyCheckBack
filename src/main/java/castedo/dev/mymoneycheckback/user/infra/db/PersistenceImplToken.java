package castedo.dev.mymoneycheckback.user.infra.db;

import castedo.dev.mymoneycheckback.user.application.ports.FindTokenPort;
import castedo.dev.mymoneycheckback.user.application.ports.SaveTokenPort;
import castedo.dev.mymoneycheckback.user.application.ports.UpdateTokenPort;
import castedo.dev.mymoneycheckback.user.dominio.Token;
import castedo.dev.mymoneycheckback.user.infra.db.entities.TokenEntity;
import castedo.dev.mymoneycheckback.user.infra.db.mappers.TokenDbMapper;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;

@Component
public class PersistenceImplToken implements SaveTokenPort, FindTokenPort, UpdateTokenPort {

    private final TokenDbMapper tokenDbMapper;
    private final TokenRepository tokenRepository;

    public PersistenceImplToken(TokenDbMapper tokenDbMapper, TokenRepository tokenRepository) {
        this.tokenDbMapper = tokenDbMapper;
        this.tokenRepository = tokenRepository;
    }

    @Override
    public void save(Token token) {
        TokenEntity tokenEntity = tokenDbMapper.toDb(token);
        tokenRepository.save(tokenEntity);
    }

    @Override
    public Token find(String tokenValue) {
        Optional<TokenEntity> optTokenEntity = tokenRepository.findByToken(tokenValue);
        Token token = tokenDbMapper.toDomain(optTokenEntity.get());
        return token;
    }

    @Override
    public int confirmedAt(String token) {
        return tokenRepository.updateConfirmedAt(token, LocalDateTime.now());
    }
}
