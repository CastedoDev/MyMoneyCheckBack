package com.castedodev.mymoneycheckback.tagoperation.adapters.out.persistence;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "TAG_OPERATION")
@Entity
public class TagOperationEntity {

    @Id
    @GeneratedValue
    private String id;

    private String tagId;
    private String operationId;

    public TagOperationEntity(){}

    public TagOperationEntity(String tagId, String operationId) {
        this.tagId = tagId;
        this.operationId = operationId;
    }

    public String getId() {
        return id;
    }

    public String getTagId() {
        return tagId;
    }

    public String getOperationId() {
        return operationId;
    }
}
