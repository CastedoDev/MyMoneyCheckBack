package com.castedodev.mymoneycheckback.operation.adapters.in.api;

import com.castedodev.mymoneycheckback.config.jwt.JwtTokenUtil;
import com.castedodev.mymoneycheckback.operation.application.services.FindOperationsService;
import com.castedodev.mymoneycheckback.operation.domain.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping({ "/v1/operation" })
public class GetFilterOperationController {

    private final FindOperationsService service;
    private final JwtTokenUtil jwtTokenUtil;

    public GetFilterOperationController(FindOperationsService service, JwtTokenUtil jwtTokenUtil) {
        this.service = service;
        this.jwtTokenUtil = jwtTokenUtil;
    }

    @GetMapping
    public ResponseEntity<?> invoke(@RequestHeader("Authorization") String token, @RequestParam String days) throws Exception {
        String username = jwtTokenUtil.getUsernameFromToken(token);
        List<Operation> operations = service.invoke(Integer.getInteger(days), username);
        return ResponseEntity.ok(operations);
    }

}
