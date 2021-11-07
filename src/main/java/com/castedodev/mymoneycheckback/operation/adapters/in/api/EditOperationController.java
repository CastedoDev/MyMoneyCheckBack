package com.castedodev.mymoneycheckback.operation.adapters.in.api;

import com.castedodev.mymoneycheckback.operation.adapters.in.api.models.SaveOperationRequest;
import com.castedodev.mymoneycheckback.operation.application.services.SaveOperationService;
import com.castedodev.mymoneycheckback.operation.domain.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping({ "/v1/operation" })
public class EditOperationController {

    private final SaveOperationService saveOperationService;

    public EditOperationController(SaveOperationService saveOperationService) {
        this.saveOperationService = saveOperationService;
    }

    @PutMapping
    public ResponseEntity<?> invoke(@RequestBody SaveOperationRequest request){
        Operation operation = new Operation(request.getId(), request.getName(), request.getDescription(), request.getAmount(), request.getDate());
        saveOperationService.invoke(operation);
        return ResponseEntity.accepted().build();
    }

}
