package com.castedodev.mymoneycheckback.operation.domain;

import java.time.LocalDate;

public class OperationCriteria {

    private final LocalDate from;
    private final LocalDate to;
    private final Integer page;
    private final Integer size;

    public OperationCriteria(LocalDate from, LocalDate to, Integer page, Integer size) {
        this.from = from;
        this.to = to;
        this.page = page;
        this.size = size;
    }


    public LocalDate getFrom() {
        return from;
    }

    public LocalDate getTo() {
        return to;
    }

    public Integer getPage() { return page; }

    public Integer getSize() { return size; }
}
