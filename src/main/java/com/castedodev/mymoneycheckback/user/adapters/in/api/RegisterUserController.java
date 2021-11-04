package com.castedodev.mymoneycheckback.user.adapters.in.api;

import com.castedodev.mymoneycheckback.user.adapters.in.api.models.NewUserRequest;
import com.castedodev.mymoneycheckback.user.domain.Usuario;
import com.castedodev.mymoneycheckback.user.services.RegisterNewUserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping({ "/v1/user" })
public class RegisterUserController {

    private final RegisterNewUserService registerNewUser;
    private final PasswordEncoder passwordEncoder;

    public RegisterUserController(RegisterNewUserService registerNewUser, PasswordEncoder passwordEncoder) {
        this.registerNewUser = registerNewUser;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/register")
    public ResponseEntity<?> invoke(@RequestBody NewUserRequest request){
        String passwordEncode = passwordEncoder.encode(request.getPassword());
        Usuario usuario = new Usuario(request.getId(), request.getUsername(), request.getEmail(), passwordEncode);
        registerNewUser.invoke(usuario);
        return ResponseEntity.accepted().build();
    }
}
