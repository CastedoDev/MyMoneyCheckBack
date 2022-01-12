package com.castedodev.mymoneycheckback.tagoperation.application;

import com.castedodev.mymoneycheckback.tagoperation.domain.TagOperationRepository;

public class DeleteTagOperationService {

    private final TagOperationRepository repository;

    public DeleteTagOperationService(TagOperationRepository repository) {
        this.repository = repository;
    }

}
