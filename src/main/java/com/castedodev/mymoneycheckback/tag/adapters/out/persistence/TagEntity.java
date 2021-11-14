package com.castedodev.mymoneycheckback.tag.adapters.out.persistence;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "TAG")
@Entity
public class TagEntity {

    @Id
    private String id;
    private String name;

    private String userId;

    public TagEntity(){}

    public TagEntity(String id, String name, String userId) {
        this.id = id;
        this.name = name;
        this.userId = userId;
    }

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
