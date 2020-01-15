package com.isoft.student;

import javax.persistence.Column;
import javax.validation.constraints.*;
import java.time.LocalDate;

/**
 * Created by mac on 12/11/2019.
 */
public class ModifyStudentCmd {
	
	@NotNull
	private Long id;
	@NotBlank
	@Pattern ( regexp = "[pfPF](nd|ND)\\d{2}321\\d{3}")
	private String matricNo;
	@NotBlank
	 private String password;
	@NotBlank
	private String surname;
	@NotBlank
	@Email
	private String email;
	private LocalDate updatedOn;
	
	public String getMatricNo () {
		return matricNo;
	}
	
	public void setMatricNo ( String matricNo ) {
		this.matricNo = matricNo;
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
	
	public Long getId () {
		return id;
	}
	
	public void setId ( Long id ) {
		this.id = id;
	}
}
