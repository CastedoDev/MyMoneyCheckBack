package com.castedodev.mymoneycheckback.operation.adapters.in.api;

import com.castedodev.mymoneycheckback.config.jwt.JwtTokenUtil;
import com.castedodev.mymoneycheckback.operation.application.FindFilterOperationsService;
import com.castedodev.mymoneycheckback.operation.domain.Operation;
import com.castedodev.mymoneycheckback.operation.domain.OperationCriteria;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

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
    public ResponseEntity<?> invoke(@RequestHeader("Authorization") String token,
                                    @RequestParam String from,
                                    @RequestParam String to,
                                    @RequestParam(required = false, defaultValue = "0") Integer page,
                                    @RequestParam(required = false, defaultValue = "10") Integer size) throws Exception {

        String username = jwtTokenUtil.getUsernameFromToken(token);
        OperationCriteria criteria = new OperationCriteria(LocalDate.parse(from), LocalDate.parse(to), page, size);
        Page<Operation> operations = service.invoke(criteria, username);
        return ResponseEntity.ok(operations);
    }

}
