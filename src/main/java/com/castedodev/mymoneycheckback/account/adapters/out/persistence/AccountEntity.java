package com.castedodev.mymoneycheckback.account.adapters.out.persistence;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ACCOUNT")
public class AccountEntity {

    @Id
    private String id;
    private String name;
    private String userId;

    public AccountEntity(String id, String name, String userId) {
        this.id = id;
        this.name = name;
        this.userId = userId;
    }

    public AccountEntity() {}

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUserId() {
        return userId;
    }
}
