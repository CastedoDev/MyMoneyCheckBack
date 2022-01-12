package com.castedodev.mymoneycheckback.tag.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "TAG")
@Entity
public class Tag {

    @Id
    private String id;
    private String name;

    private String userId;

    public Tag(){}

    public Tag(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public void setUserId(String userId) { this.userId = userId; }

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
