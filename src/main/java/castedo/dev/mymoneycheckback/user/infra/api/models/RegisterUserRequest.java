package castedo.dev.mymoneycheckback.user.infra.api.models;

import lombok.Data;

@Data
public class RegisterUserRequest {
    private String id;
    private String username;
    private String email;
    private String password;

}
