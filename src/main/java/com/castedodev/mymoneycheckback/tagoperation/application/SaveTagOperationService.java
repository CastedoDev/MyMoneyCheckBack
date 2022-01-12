package com.castedodev.mymoneycheckback.tagoperation.application;

import com.castedodev.mymoneycheckback.tagoperation.domain.TagOperation;
import com.castedodev.mymoneycheckback.tagoperation.domain.TagOperationRepository;
import org.springframework.stereotype.Service;

@Service
public class SaveTagOperationService {

    private final TagOperationRepository repository;

    public SaveTagOperationService(TagOperationRepository repository) {
        this.repository = repository;
    }

    public void invoke(TagOperation tagoperation){
        repository.save(tagoperation);
    }
}
