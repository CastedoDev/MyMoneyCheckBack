package com.castedodev.mymoneycheckback.operation.application.services;

import com.castedodev.mymoneycheckback.operation.application.ports.out.SaveOperationPort;
import com.castedodev.mymoneycheckback.operation.domain.Operation;
import org.springframework.stereotype.Service;

@Service
public class SaveOperationService {

    private final SaveOperationPort saveOperationPort;

    public SaveOperationService(SaveOperationPort saveOperationPort) {
        this.saveOperationPort = saveOperationPort;
    }

    public void invoke(Operation operation){
        saveOperationPort.save(operation);
    }

}
