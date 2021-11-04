package com.castedodev.mymoneycheckback.user.adapters.in.api.models;

import java.io.Serializable;

public class LoginUserResponse implements Serializable {

	private static final long serialVersionUID = -8091879091924046844L;
	private final String jwttoken;

	public LoginUserResponse(String jwttoken) {
		this.jwttoken = jwttoken;
	}

	public String getToken() {
		return this.jwttoken;
	}
}