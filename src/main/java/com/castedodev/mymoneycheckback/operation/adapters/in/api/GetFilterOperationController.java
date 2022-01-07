package com.castedodev.mymoneycheckback.operation.adapters.in.api;

import com.castedodev.mymoneycheckback.config.jwt.JwtTokenUtil;
import com.castedodev.mymoneycheckback.operation.adapters.in.api.models.FilterOperationCriteria;
import com.castedodev.mymoneycheckback.operation.application.services.FindFilterOperationsService;
import com.castedodev.mymoneycheckback.operation.domain.Operation;
import com.castedodev.mymoneycheckback.operation.domain.OperationCriteria;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping({ "/v1/operation/filter" })
public class GetFilterOperationController {

    private final FindFilterOperationsService service;
    private final JwtTokenUtil jwtTokenUtil;

    public GetFilterOperationController(FindFilterOperationsService service, JwtTokenUtil jwtTokenUtil) {
        this.service = service;
        this.jwtTokenUtil = jwtTokenUtil;
    }

    @GetMapping
    public ResponseEntity<?> invoke(@RequestHeader("Authorization") String token, @RequestBody OperationCriteria criteria) throws Exception {
        String username = jwtTokenUtil.getUsernameFromToken(token);
        List<Operation> operations = service.invoke(criteria);
        return ResponseEntity.ok(operations);
    }

}
