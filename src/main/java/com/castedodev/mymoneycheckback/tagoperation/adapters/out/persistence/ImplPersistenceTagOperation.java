package com.castedodev.mymoneycheckback.tagoperation.adapters.out.persistence;

import com.castedodev.mymoneycheckback.tagoperation.application.ports.out.DeleteTagOperationPort;
import com.castedodev.mymoneycheckback.tagoperation.application.ports.out.SaveTagOperationPort;
import com.castedodev.mymoneycheckback.tagoperation.domain.TagOperation;
import org.springframework.stereotype.Component;

@Component
public class ImplPersistenceTagOperation implements SaveTagOperationPort, DeleteTagOperationPort {

    private final TagOperationRepository repository;

    public ImplPersistenceTagOperation(TagOperationRepository repository) {
        this.repository = repository;
    }


    @Override
    public void save(TagOperation tagoperation) {
        TagOperationEntity tagOperationEntity = new TagOperationEntity(tagoperation.getTagId(), tagoperation.getOperationId());
        repository.save(tagOperationEntity);
    }

    @Override
    public void deleteByOperationId(String operationId) {
        repository.findByOperationId(operationId).stream()
                .map(TagOperationEntity::getId)
                .forEach(repository::deleteById);
    }
}
