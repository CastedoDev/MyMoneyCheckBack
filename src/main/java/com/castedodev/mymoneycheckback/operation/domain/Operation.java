package com.castedodev.mymoneycheckback.operation.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Table(name = "operations")
@Entity
public class Operation {

    @Id
    private String id;
    private String name;
    private String description;
    private Float amount;
    private LocalDate date;

    private String accountId;
    private String userId;

    public Operation() {
    }

    public Operation(String id, String name, String description, Float amount, LocalDate date) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.amount = amount;
        this.date = date;
    }

    public void setAccountId(String accountId) { this.accountId = accountId; }

    public void setUserId(String userId) { this.userId = userId; }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() { return description; }

    public Float getAmount() {
        return amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getUserId() { return userId; }

    public String getAccountId() {
        return accountId;
    }
}
