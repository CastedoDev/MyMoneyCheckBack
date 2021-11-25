package com.castedodev.mymoneycheckback.operation.application.services;

import com.castedodev.mymoneycheckback.operation.application.ports.out.SaveOperationPort;
import com.castedodev.mymoneycheckback.operation.domain.Operation;
import com.castedodev.mymoneycheckback.tagoperation.application.services.SaveTagOperationService;
import com.castedodev.mymoneycheckback.tagoperation.domain.TagOperation;
import com.castedodev.mymoneycheckback.user.application.services.FindUserService;
import com.castedodev.mymoneycheckback.user.domain.NotUserFound;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaveOperationService {

    private final SaveOperationPort saveOperationPort;
    private final SaveTagOperationService saveTagOperationService;
    private final FindUserService findUserService;

    public SaveOperationService(SaveOperationPort saveOperationPort, SaveTagOperationService saveTagOperationService, FindUserService findUserService) {
        this.saveOperationPort = saveOperationPort;
        this.saveTagOperationService = saveTagOperationService;
        this.findUserService = findUserService;
    }

    public void invoke(Operation operation, List<String> tagsId, String username) throws NotUserFound {
        String userId = findUserService.findByUsername(username).getId();
        saveOperationPort.save(operation, userId);

        tagsId.stream()
                .map(tagTd -> new TagOperation(tagTd, operation.getId()))
                .forEach(saveTagOperationService::invoke);
    }

}
