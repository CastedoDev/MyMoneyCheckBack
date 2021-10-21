package castedo.dev.mymoneycheckback.user.infra.db.mappers;

import castedo.dev.mymoneycheckback.user.dominio.User;
import castedo.dev.mymoneycheckback.user.infra.db.entities.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserDbMapper {

    public UserEntity toDb(User user){
        return new UserEntity(user.getId(), user.getUsername(), user.getEmail(), user.getPassword());
    }

}
