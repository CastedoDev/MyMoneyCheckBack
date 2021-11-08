package com.castedodev.mymoneycheckback.operation.application.services;

import com.castedodev.mymoneycheckback.operation.application.ports.out.SaveOperationPort;
import com.castedodev.mymoneycheckback.operation.domain.Operation;
import com.castedodev.mymoneycheckback.user.application.ports.out.FindUserByUsernamePort;
import com.castedodev.mymoneycheckback.user.application.services.FindUserService;
import com.castedodev.mymoneycheckback.user.domain.NotUserFound;
import org.springframework.stereotype.Service;

@Service
public class SaveOperationService {

    private final SaveOperationPort saveOperationPort;
    private final FindUserService findUserService;

    public SaveOperationService(SaveOperationPort saveOperationPort, FindUserService findUserService) {
        this.saveOperationPort = saveOperationPort;
        this.findUserService = findUserService;
    }

    public void invoke(Operation operation, String username) throws NotUserFound {
        String userId = findUserService.findByUsername(username).getId();
        saveOperationPort.save(operation, userId);
    }

}
