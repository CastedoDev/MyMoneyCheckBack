package com.castedodev.mymoneycheckback.tagoperation.domain;

public class TagOperation {

    private final String tagId;
    private final String operationId;

    public TagOperation(String tagId, String operationId) {
        this.tagId = tagId;
        this.operationId = operationId;
    }

    public String getTagId() {
        return tagId;
    }

    public String getOperationId() {
        return operationId;
    }
}
