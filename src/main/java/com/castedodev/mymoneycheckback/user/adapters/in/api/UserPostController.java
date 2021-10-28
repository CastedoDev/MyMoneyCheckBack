package com.castedodev.mymoneycheckback.user.adapters.in.api;

import com.castedodev.mymoneycheckback.user.domain.User;
import com.castedodev.mymoneycheckback.user.services.RegisterNewUserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin()
@RestController
@RequestMapping({ "/user" })
public class UserPostController {

    private final RegisterNewUserService registerNewUser;

    public UserPostController(RegisterNewUserService registerNewUser) {
        this.registerNewUser = registerNewUser;
    }

    @PostMapping("register")
    public ResponseEntity<?> invoke(@RequestBody RegisterNewUserDTO request){
        User user = new User(request.getId(), request.getUsername(), request.getEmail(), request.getPassword());
        registerNewUser.invoke(user);
        return ResponseEntity.accepted().build();
    }
}
