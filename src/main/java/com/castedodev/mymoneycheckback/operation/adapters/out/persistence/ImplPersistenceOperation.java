package com.castedodev.mymoneycheckback.operation.adapters.out.persistence;

import com.castedodev.mymoneycheckback.operation.application.ports.out.*;
import com.castedodev.mymoneycheckback.operation.domain.Operation;
import com.castedodev.mymoneycheckback.operation.domain.OperationCriteria;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class ImplPersistenceOperation implements SaveOperationPort, DeleteOperationPort, FindByIdOperationPort, CheckIfExistByIdPort, FindByDaysPort, FindByCriteriaOperationPort {

    private final OperationRepository repository;

    public ImplPersistenceOperation(OperationRepository repository) {
        this.repository = repository;
    }

    @Override
    public void save(Operation operation, String accountId, String userId) {
        OperationEntity operationEntity = new OperationEntity(
                operation.getId(),
                operation.getName(),
                operation.getDescription(),
                operation.getAmount(),
                operation.getDate(),
                accountId,
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

    @Override
    public List<Operation> findByDays(Integer days, String userId) {
        return repository.findAll().stream()
                .map(tagEntity -> new Operation(tagEntity.getId(), tagEntity.getName(), tagEntity.getDescription(), tagEntity.getAmount(), tagEntity.getDate()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Operation> findByCriteria(OperationCriteria criteria) {
        return repository.;
    }
}