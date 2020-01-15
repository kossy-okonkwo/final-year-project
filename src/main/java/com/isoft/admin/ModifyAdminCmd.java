package com.isoft.admin;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

/**
 * Created by mac on 24/12/2019.
 */
public class ModifyAdminCmd {
	
	@NotNull
	private Long id;
	@NotBlank
	private String username;
	@NotBlank
	private String password;
	@NotBlank
	private String surname;
	@NotBlank
	@Email
	private String email;
	private LocalDate updatedOn;
	
	public Long getId () {
		return id;
	}
	
	public void setId ( Long id ) {
		this.id = id;
	}
	
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
	
	public LocalDate getUpdatedOn () {
		return updatedOn;
	}
	
	public void setUpdatedOn ( LocalDate updatedOn ) {
		this.updatedOn = updatedOn;
	}
}
