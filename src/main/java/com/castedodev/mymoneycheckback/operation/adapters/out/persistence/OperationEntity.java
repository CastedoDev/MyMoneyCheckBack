package com.castedodev.mymoneycheckback.operation.adapters.out.persistence;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Table(name = "operations")
@Entity
public class OperationEntity {

    @Id
    private String id;
    private String name;
    private String description;
    private Float amount;
    private LocalDate date;

    private String accountId;
    private String userId;

    public OperationEntity() {
    }

    public OperationEntity(String id, String name, String description, Float amount, LocalDate date, String accountId, String userId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.amount = amount;
        this.date = date;
        this.accountId = accountId;
        this.userId = userId;
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

    public String getUserId() {return userId;}
}
