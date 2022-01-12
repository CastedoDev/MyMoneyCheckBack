package com.castedodev.mymoneycheckback.operation.application;

import com.castedodev.mymoneycheckback.operation.domain.Operation;
import com.castedodev.mymoneycheckback.operation.domain.OperationRepository;
import com.castedodev.mymoneycheckback.tagoperation.application.SaveTagOperationService;
import com.castedodev.mymoneycheckback.tagoperation.domain.TagOperation;
import com.castedodev.mymoneycheckback.user.application.services.FindUserService;
import com.castedodev.mymoneycheckback.user.domain.NotUserFound;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaveOperationService {

    private final OperationRepository repository;
    private final SaveTagOperationService saveTagOperationService;
    private final FindUserService findUserService;

    public SaveOperationService(OperationRepository repository, SaveTagOperationService saveTagOperationService, FindUserService findUserService) {
        this.repository = repository;
        this.saveTagOperationService = saveTagOperationService;
        this.findUserService = findUserService;
    }

    public void invoke(Operation operation, List<String> tagsId, String accountId, String username) throws NotUserFound {
        String userId = findUserService.findByUsername(username).getId();
        operation.setAccountId(accountId);
        operation.setUserId(userId);

        repository.save(operation);

        tagsId.stream()
                .map(tagTd -> new TagOperation(tagTd, operation.getId()))
                .forEach(saveTagOperationService::invoke);
    }

}
