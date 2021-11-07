package com.castedodev.mymoneycheckback.operation.application.services;

import com.castedodev.mymoneycheckback.operation.application.ports.out.DeleteOperationPort;
import org.springframework.stereotype.Service;

@Service
public class DeleteOperationService {

    private final DeleteOperationPort deleteOperationPort;

    public DeleteOperationService(DeleteOperationPort deleteOperationPort) {
        this.deleteOperationPort = deleteOperationPort;
    }

    public void invoke(String id){
        deleteOperationPort.delete(id);
    }
}
