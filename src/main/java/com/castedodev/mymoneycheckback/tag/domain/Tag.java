package com.castedodev.mymoneycheckback.tag.domain;

public class Tag {

    private final String id;
    private final String Name;

    public Tag(String id, String name) {
        this.id = id;
        Name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return Name;
    }
}
