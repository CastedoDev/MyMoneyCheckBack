package com.castedodev.mymoneycheckback.operation.adapters.out.persistence;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Table
@Entity
public class OperationEntity {

    @Id
    private String id;
    private String name;
    private String description;
    private Float amount;
    private LocalDate date;

    public OperationEntity() {
    }

    public OperationEntity(String id, String name, String description, Float amount, LocalDate date) {
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
