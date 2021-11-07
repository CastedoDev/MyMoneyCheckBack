package com.castedodev.mymoneycheckback.operation.application.services;

import com.castedodev.mymoneycheckback.operation.application.ports.out.FindByIdOperationPort;
import com.castedodev.mymoneycheckback.operation.application.ports.out.UpdateOperationPort;
import com.castedodev.mymoneycheckback.operation.domain.Operation;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EditOperationService {

    private final FindByIdOperationPort findByIdOperationPort;
    private final UpdateOperationPort updateOperationPort;

    public EditOperationService(FindByIdOperationPort findByIdOperationPort, UpdateOperationPort updateOperationPort) {
        this.findByIdOperationPort = findByIdOperationPort;
        this.updateOperationPort = updateOperationPort;
    }

    public void invoke(Operation operation) throws Exception {
        Optional<Operation> operationDB = findByIdOperationPort.findById(operation.getId());
        if(operationDB.isPresent()){
            updateOperationPort.update(operation);
        } else {
            throw new Exception();
        }
    }

}
