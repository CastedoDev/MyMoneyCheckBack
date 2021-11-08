package com.castedodev.mymoneycheckback.operation.adapters.in.api;

import com.castedodev.mymoneycheckback.config.jwt.JwtTokenUtil;
import com.castedodev.mymoneycheckback.operation.adapters.in.api.models.SaveOperationRequest;
import com.castedodev.mymoneycheckback.operation.application.services.SaveOperationService;
import com.castedodev.mymoneycheckback.operation.domain.Operation;
import com.castedodev.mymoneycheckback.user.domain.NotUserFound;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping({ "/v1/operation" })
public class SaveOperationController {

    private final SaveOperationService saveOperationService;
    private final JwtTokenUtil jwtTokenUtil;

    public SaveOperationController(SaveOperationService saveOperationService, JwtTokenUtil jwtTokenUtil) {
        this.saveOperationService = saveOperationService;
        this.jwtTokenUtil = jwtTokenUtil;
    }

    @PostMapping
    public ResponseEntity<?> invoke(@RequestHeader("Authorization") String token, @RequestBody SaveOperationRequest request) throws NotUserFound {
        String username = jwtTokenUtil.getUsernameFromToken(token);
        Operation operation = new Operation(request.getId(), request.getName(), request.getDescription(), request.getAmount(), request.getDate());
        saveOperationService.invoke(operation, username);
        return ResponseEntity.accepted().build();
    }

}
