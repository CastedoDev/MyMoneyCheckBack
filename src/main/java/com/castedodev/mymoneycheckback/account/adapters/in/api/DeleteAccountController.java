package com.castedodev.mymoneycheckback.account.adapters.in.api;

import com.castedodev.mymoneycheckback.account.application.services.DeleteAccountService;
import com.castedodev.mymoneycheckback.account.application.services.SaveAccountService;
import com.castedodev.mymoneycheckback.account.domain.Account;
import com.castedodev.mymoneycheckback.config.jwt.JwtTokenUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping({ "/v1/account" })
public class DeleteAccountController {

    private final JwtTokenUtil jwtTokenUtil;
    private final DeleteAccountService service;

    public DeleteAccountController(JwtTokenUtil jwtTokenUtil, DeleteAccountService service) {
        this.jwtTokenUtil = jwtTokenUtil;
        this.service = service;
    }

    @DeleteMapping
    public ResponseEntity<?> invoke(@RequestHeader("Authorization") String token, @RequestParam String id) {
        service.invoke(id);
        return ResponseEntity.accepted().build();
    }

}
