package com.castedodev.mymoneycheckback.account.adapters.in.api;

import com.castedodev.mymoneycheckback.account.application.services.SaveAccountService;
import com.castedodev.mymoneycheckback.account.domain.Account;
import com.castedodev.mymoneycheckback.config.jwt.JwtTokenUtil;
import com.castedodev.mymoneycheckback.user.domain.NotUserFound;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping({ "/v1/account" })
public class PostAccountController {

    private final JwtTokenUtil jwtTokenUtil;
    private final SaveAccountService service;

    public PostAccountController(JwtTokenUtil jwtTokenUtil, SaveAccountService service) {
        this.jwtTokenUtil = jwtTokenUtil;
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<?> invoke(@RequestHeader("Authorization") String token, @RequestBody Account account) throws NotUserFound {
        String username = jwtTokenUtil.getUsernameFromToken(token);
        service.invoke(account, username);
        return ResponseEntity.accepted().build();
    }

}
