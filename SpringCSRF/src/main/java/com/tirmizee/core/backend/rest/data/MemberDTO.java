package com.tirmizee.core.backend.rest.data;

import java.io.Serializable;

public class MemberDTO implements Serializable {

	private static final long serialVersionUID = -126060170489808028L;

	private String username;
	private String password;

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
