package com.castedodev.mymoneycheckback.operation.adapters.in.api.models;

import java.time.LocalDate;

public class FilterOperationCriteria {

    private final LocalDate from;
    private final LocalDate to;

    public FilterOperationCriteria(LocalDate from, LocalDate to) {
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
