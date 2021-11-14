package com.castedodev.mymoneycheckback.operation.adapters.in.api.models;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.util.List;

public class SaveOperationRequest {

    private final String id;
    private final String name;
    private final String description;
    private final Float amount;

    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private final LocalDate date;

    private final List<String> tagsId;

    public SaveOperationRequest(String id, String name, String description, Float amount, LocalDate date, List<String> tagsId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.amount = amount;
        this.date = date;
        this.tagsId = tagsId;
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

    public List<String> getTagsId() {
        return tagsId;
    }
}
