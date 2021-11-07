package com.castedodev.mymoneycheckback.operation.domain;

import java.time.LocalDate;

public class Operation {

    private final String id;
    private final String name;
    private final String description;
    private final Float amount;
    private final LocalDate date;

    public Operation(String id, String name, String description, Float amount, LocalDate date) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.amount = amount;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Float getAmount() {
        return amount;
    }

    public LocalDate getDate() {
        return date;
    }
}
