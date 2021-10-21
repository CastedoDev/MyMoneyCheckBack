package castedo.dev.mymoneycheckback.user.infra.api.controllers;

import castedo.dev.mymoneycheckback.user.application.UserService;
import castedo.dev.mymoneycheckback.user.dominio.Role;
import castedo.dev.mymoneycheckback.user.dominio.User;
import castedo.dev.mymoneycheckback.user.infra.api.UserApiMapper;
import castedo.dev.mymoneycheckback.user.infra.api.models.RegisterUserRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(path = "api/v1/register")
public class RegisterUserController {

    public final UserService userService;
    public final UserApiMapper mapper;

    public RegisterUserController(UserService userService, UserApiMapper mapper) {
        this.userService = userService;
        this.mapper = mapper;
    }

    @PutMapping
    public ResponseEntity<String> call(@RequestBody RegisterUserRequest request) {
        User user = mapper.registerUserToDomain(request, Role.USER);
        userService.invoke(user);
        return new ResponseEntity<>("User saved", HttpStatus.OK);
    }



}