package com.castedodev.mymoneycheckback.operation.adapters.in.api;

import com.castedodev.mymoneycheckback.operation.application.services.DeleteOperationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping({ "/v1/operation" })
public class RemoveOperationController {

    private final DeleteOperationService service;

    public RemoveOperationController(DeleteOperationService service) {
        this.service = service;
    }

    @DeleteMapping
    public ResponseEntity<?> call(@RequestParam String id){
        service.invoke(id);
        return ResponseEntity.accepted().build();
    }


}
