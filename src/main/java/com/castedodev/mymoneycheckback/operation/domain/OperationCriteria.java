package com.castedodev.mymoneycheckback.operation.domain;

import java.time.LocalDate;

public class OperationCriteria {

    private final LocalDate from;
    private final LocalDate to;

    public OperationCriteria(LocalDate from, LocalDate to) {
        this.from = from;
        this.to = to;
    }

    public LocalDate getFrom() {
        return from;
    }

    public LocalDate getTo() {
        return to;
    }
}
