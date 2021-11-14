package com.castedodev.mymoneycheckback.tagoperation.application.services;

import com.castedodev.mymoneycheckback.tagoperation.application.ports.out.SaveTagOperationPort;
import com.castedodev.mymoneycheckback.tagoperation.domain.TagOperation;
import org.springframework.stereotype.Service;

@Service
public class SaveTagOperationService {

    private final SaveTagOperationPort saveTagOperationPort;

    public SaveTagOperationService(SaveTagOperationPort saveTagOperationPort) {
        this.saveTagOperationPort = saveTagOperationPort;
    }

    public void invoke(TagOperation tagoperation){
        saveTagOperationPort.save(tagoperation);
    }
}
