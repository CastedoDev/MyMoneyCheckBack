package castedo.dev.mymoneycheckback.user.infra.api;

import castedo.dev.mymoneycheckback.user.dominio.Role;
import castedo.dev.mymoneycheckback.user.dominio.User;
import castedo.dev.mymoneycheckback.user.infra.api.models.RegisterUserRequest;
import org.springframework.stereotype.Component;

@Component
public class UserApiMapper {
    public User registerUserToDomain(RegisterUserRequest request, Role role){
        return new User(request.getId(), request.getUsername(), request.getEmail(), request.getPassword(), role);
    }
}
