package com.isoft.admin;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * Created by mac on 03/12/2019.
 */
public class NewAdminCmd {
	@NotBlank
	private String username;
//	@NotBlank
	private String password;
	@NotBlank
	private String surname;
	@Email
	private String email;
	
	public String getUsername () {
		return username;
	}
	
	public void setUsername ( String username ) {
		this.username = username;
	}
	
	public String getPassword () {
		return password;
	}
	
	public void setPassword ( String password ) {
		this.password = password;
	}
	
	public String getSurname () {
		return surname;
	}
	
	public void setSurname ( String surname ) {
		this.surname = surname;
	}
	
	public String getEmail () {
		return email;
	}
	
	public void setEmail ( String email ) {
		this.email = email;
	}
}
