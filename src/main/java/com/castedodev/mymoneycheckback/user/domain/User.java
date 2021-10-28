package com.castedodev.mymoneycheckback.user.domain;

import java.util.ArrayList;
import java.util.List;

public class User {

    private final String id;
    private final String username;
    private final String email;
    private final String password;
    private final List<String> roles;

    public User(String id, String username, String email, String password, List<String> roles) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }

    public User(String id, String username, String email, String password){
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.roles = new ArrayList<String>();
    }

    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public List<String> getRoles() {
        return roles;
    }
}
