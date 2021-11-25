package com.castedodev.mymoneycheckback.user.adapters.in.api.models;

import java.io.Serializable;

public class LoginUserRequest implements Serializable {

	private static final long serialVersionUID = 5926468583005150707L;
	
	private String identifier;
	private String password;

	public LoginUserRequest() {}

	public LoginUserRequest(String identifier, String password) {
		this.setIdentifier(identifier);
		this.setPassword(password);
	}

	public String getIdentifier() {
		return this.identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}