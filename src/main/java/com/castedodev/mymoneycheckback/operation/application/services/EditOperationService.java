package com.castedodev.mymoneycheckback.operation.application.services;

import com.castedodev.mymoneycheckback.operation.application.ports.out.CheckIfExistByIdPort;
import com.castedodev.mymoneycheckback.operation.application.ports.out.SaveOperationPort;
import com.castedodev.mymoneycheckback.operation.domain.Operation;
import com.castedodev.mymoneycheckback.user.application.services.FindUserService;
import org.springframework.stereotype.Service;

@Service
public class EditOperationService {

    private final CheckIfExistByIdPort checkIfExistsByIdPort;
    private final SaveOperationPort saveOperationPort;
    private final FindUserService findUserService;

    public EditOperationService(CheckIfExistByIdPort checkIfExistsByIdPort, SaveOperationPort saveOperationPort, FindUserService findUserService) {
        this.checkIfExistsByIdPort = checkIfExistsByIdPort;
        this.saveOperationPort = saveOperationPort;
        this.findUserService = findUserService;
    }

    public void invoke(Operation operation, String username) throws Exception {
        String userId = findUserService.findByUsername(username).getId();
        if(checkIfExistsByIdPort.checkIfExistsById(operation.getId())){
            saveOperationPort.save(operation, userId);
        } else {
            throw new Exception();
        }
    }

}
