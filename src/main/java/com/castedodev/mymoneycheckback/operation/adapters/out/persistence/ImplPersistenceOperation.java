package com.castedodev.mymoneycheckback.operation.adapters.out.persistence;

import com.castedodev.mymoneycheckback.operation.application.ports.out.DeleteOperationPort;
import com.castedodev.mymoneycheckback.operation.application.ports.out.FindByIdOperationPort;
import com.castedodev.mymoneycheckback.operation.application.ports.out.SaveOperationPort;
import com.castedodev.mymoneycheckback.operation.application.ports.out.UpdateOperationPort;
import com.castedodev.mymoneycheckback.operation.domain.Operation;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ImplPersistenceOperation implements SaveOperationPort, DeleteOperationPort, FindByIdOperationPort, UpdateOperationPort {

    private final OperationRepository repository;

    public ImplPersistenceOperation(OperationRepository repository) {
        this.repository = repository;
    }

    @Override
    public void save(Operation operation) {
        OperationEntity operationEntity = new OperationEntity(operation.getId(), operation.getName(), operation.getDescription(), operation.getAmount(), operation.getDate());
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
    public void update(Operation operation) {
        Optional<OperationEntity> optOperationEntity = repository.findById(operation.getId());
        if(optOperationEntity.isPresent()){

        }
    }
}