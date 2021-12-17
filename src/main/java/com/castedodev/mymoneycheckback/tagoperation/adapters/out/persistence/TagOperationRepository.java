package com.castedodev.mymoneycheckback.tagoperation.adapters.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TagOperationRepository extends JpaRepository<TagOperationEntity, String> {

    List<TagOperationEntity> findByOperationId(String operationId);
}
