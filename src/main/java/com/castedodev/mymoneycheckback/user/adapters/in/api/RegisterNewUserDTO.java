package com.castedodev.mymoneycheckback.user.adapters.in.api;

public class RegisterNewUserDTO {

    private final String id;
    private final String username;
    private final String email;
    private final String password;

    public RegisterNewUserDTO(String id, String username, String email, String password) {
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
