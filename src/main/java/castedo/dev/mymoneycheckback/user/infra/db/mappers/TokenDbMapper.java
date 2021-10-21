package castedo.dev.mymoneycheckback.user.infra.db.mappers;

import castedo.dev.mymoneycheckback.user.dominio.Token;
import castedo.dev.mymoneycheckback.user.infra.db.entities.TokenEntity;
import org.springframework.stereotype.Component;

@Component
public class TokenDbMapper {

    private final UserDbMapper userDbMapper;

    public TokenDbMapper(UserDbMapper userDbMapper) {
        this.userDbMapper = userDbMapper;
    }

    public TokenEntity toDb(Token token){
        return new TokenEntity(
                token.getToken(),
                token.getCreatedAt(),
                token.getExpiresAt(),
                userDbMapper.toDb(token.getUser())
        );
    }

    public Token toDomain(TokenEntity tokenEntity){
        return new Token();
    }

}
