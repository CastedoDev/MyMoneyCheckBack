package com.castedodev.mymoneycheckback.operation.adapters.out.persistence;

import com.castedodev.mymoneycheckback.operation.application.ports.out.*;
import com.castedodev.mymoneycheckback.operation.domain.Operation;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ImplPersistenceOperation implements SaveOperationPort, DeleteOperationPort, FindByIdOperationPort, CheckIfExistByIdPort {

    private final OperationRepository repository;

    public ImplPersistenceOperation(OperationRepository repository) {
        this.repository = repository;
    }

    @Override
    public void save(Operation operation, String userId) {
        OperationEntity operationEntity = new OperationEntity(
                operation.getId(),
                operation.getName(),
                operation.getDescription(),
                operation.getAmount(),
                operation.getDate(),
                userId);
        repository.save(operationEntity);
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<Operation> findById(String id) {
        Optional<OperationEntity> operationEntityOptional = repository.findById(id);
        if(operationEntityOptional.isPresent()){
            OperationEntity operationEntity = operationEntityOptional.get();
            Operation operation = new Operation(operationEntity.getId(), operationEntity.getName(), operationEntity.getDescription(), operationEntity.getAmount(), operationEntity.getDate());
            return Optional.of(operation);
        }
        return Optional.empty();
    }

    @Override
    public Boolean checkIfExistsById(String id) {
        return repository.existsById(id);
    }

}