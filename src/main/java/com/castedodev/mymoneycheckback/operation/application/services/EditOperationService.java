package com.castedodev.mymoneycheckback.operation.application.services;

import com.castedodev.mymoneycheckback.operation.application.ports.out.CheckIfExistByIdPort;
import com.castedodev.mymoneycheckback.operation.application.ports.out.SaveOperationPort;
import com.castedodev.mymoneycheckback.operation.domain.Operation;
import org.springframework.stereotype.Service;

@Service
public class EditOperationService {

    private final CheckIfExistByIdPort checkIfExistsByIdPort;
    private final SaveOperationPort saveOperationPort;

    public EditOperationService(CheckIfExistByIdPort checkIfExistsByIdPort, SaveOperationPort saveOperationPort) {
        this.checkIfExistsByIdPort = checkIfExistsByIdPort;
        this.saveOperationPort = saveOperationPort;
    }

    public void invoke(Operation operation, String userId) throws Exception {
        if(checkIfExistsByIdPort.checkIfExistsById(operation.getId())){
            saveOperationPort.save(operation, userId);
        } else {
            throw new Exception();
        }
    }

}
