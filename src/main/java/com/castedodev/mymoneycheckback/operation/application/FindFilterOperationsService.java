package com.castedodev.mymoneycheckback.operation.application;

import com.castedodev.mymoneycheckback.operation.domain.Operation;
import com.castedodev.mymoneycheckback.operation.domain.OperationCriteria;
import com.castedodev.mymoneycheckback.operation.domain.OperationRepository;
import com.castedodev.mymoneycheckback.user.application.services.FindUserService;
import com.castedodev.mymoneycheckback.user.domain.NotUserFound;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindFilterOperationsService {

    private final OperationRepository repository;
    private final FindUserService userService;

    public FindFilterOperationsService(OperationRepository repository, FindUserService userService) {
        this.repository = repository;
        this.userService = userService;
    }

    public List<Operation> invoke(OperationCriteria criteria, String username) throws NotUserFound {
        String userId = userService.findByUsername(username).getId();
        return repository.getAllBetweenDates(criteria.getFrom(), criteria.getTo(), userId);
    }
}
