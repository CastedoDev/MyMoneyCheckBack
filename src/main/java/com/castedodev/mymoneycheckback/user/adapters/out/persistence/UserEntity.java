package com.castedodev.mymoneycheckback.user.adapters.out.persistence;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "USERS")
@Entity
public class UserEntity {

    @Id
    private String id;
    private String username;
    private String email;
    private String password;

    public UserEntity(){}

    public UserEntity(String id, String username, String email, String password) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
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
}
