package com.castedodev.mymoneycheckback.operation.adapters.in.api;

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

    public EditOperationController(EditOperationService editOperationService) {
        this.editOperationService = editOperationService;
    }

    @PutMapping
    public ResponseEntity<?> invoke(@RequestBody SaveOperationRequest request) throws Exception {
        Operation operation = new Operation(request.getId(), request.getName(), request.getDescription(), request.getAmount(), request.getDate());
        //editOperationService.invoke(operation);
        return ResponseEntity.accepted().build();
    }

}
