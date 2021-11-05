package com.castedodev.mymoneycheckback.item.domain;

import java.time.LocalDateTime;

public class Record {

    private final String id;
    private final String name;
    private final String description;
    private final Float amount;
    private final LocalDateTime dateTime;

    public Record(String id, String name, String description, Float amount, LocalDateTime dateTime) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.amount = amount;
        this.dateTime = dateTime;
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

    public LocalDateTime getDateTime() {
        return dateTime;
    }
}
