package com.castedodev.mymoneycheckback.tagoperation.domain;

import com.castedodev.mymoneycheckback.tagoperation.adapters.out.persistence.TagOperationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TagOperationRepository extends JpaRepository<TagOperation, String> {

    List<TagOperation> findByOperationId(String operationId);
}
