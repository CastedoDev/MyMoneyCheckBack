package com.castedodev.mymoneycheckback.operation.application;

import com.castedodev.mymoneycheckback.operation.domain.Operation;
import com.castedodev.mymoneycheckback.operation.domain.OperationRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DeleteOperationService {

    private final OperationRepository repository;

    public DeleteOperationService(OperationRepository repository) {
        this.repository = repository;
    }

    public void invoke(String id){
        Optional<Operation> op = repository.findById(id);
        op.ifPresent(repository::delete);
    }
}
