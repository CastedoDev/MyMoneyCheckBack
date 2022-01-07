package com.castedodev.mymoneycheckback.operation.adapters.in.api;

import com.castedodev.mymoneycheckback.config.jwt.JwtTokenUtil;
import com.castedodev.mymoneycheckback.operation.adapters.in.api.models.SaveOperationRequest;
import com.castedodev.mymoneycheckback.operation.application.services.EditOperationService;
import com.castedodev.mymoneycheckback.operation.domain.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping({ "/v1/operation" })
public class EditOperationController {

    private final EditOperationService editOperationService;
    private final JwtTokenUtil jwtTokenUtil;

    public EditOperationController(EditOperationService editOperationService, JwtTokenUtil jwtTokenUtil) {
        this.editOperationService = editOperationService;
        this.jwtTokenUtil = jwtTokenUtil;
    }

    @PutMapping
    public ResponseEntity<?> invoke(@RequestHeader("Authorization") String token, @ SaveOperationRequest request) throws Exception {
        String username = jwtTokenUtil.getUsernameFromToken(token);
        Operation operation = new Operation(request.getId(), request.getName(), request.getDescription(), request.getAmount(), request.getDate());
        editOperationService.invoke(operation, request.getAccountId(), username);
        return ResponseEntity.accepted().build();
    }

}
