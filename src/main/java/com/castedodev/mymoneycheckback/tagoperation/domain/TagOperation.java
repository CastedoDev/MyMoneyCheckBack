package com.castedodev.mymoneycheckback.tagoperation.domain;

import javax.persistence.*;

@Table(name = "TAG_OPERATION")
@Entity
public class TagOperation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    private String tagId;
    private String operationId;

    public TagOperation(){}

    public TagOperation(String tagId, String operationId) {
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
