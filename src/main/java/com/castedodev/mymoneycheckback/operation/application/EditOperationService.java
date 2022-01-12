package com.castedodev.mymoneycheckback.operation.application;

import com.castedodev.mymoneycheckback.operation.domain.Operation;
import com.castedodev.mymoneycheckback.operation.domain.OperationRepository;
import com.castedodev.mymoneycheckback.user.application.services.FindUserService;
import org.springframework.stereotype.Service;

@Service
public class EditOperationService {

    private final OperationRepository repository;
    private final FindUserService findUserService;

    public EditOperationService(OperationRepository repository, FindUserService findUserService) {
        this.repository = repository;
        this.findUserService = findUserService;
    }

    public void invoke(Operation operation, String accountId, String username) throws Exception {
        String userId = findUserService.findByUsername(username).getId();

        operation.setAccountId(accountId);
        operation.setUserId(userId);
        repository.findById(operation.getId()).ifPresent(repository::save);
    }

}
