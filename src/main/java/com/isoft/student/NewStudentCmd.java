package com.isoft.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import javax.persistence.Column;
import javax.validation.constraints.*;
import java.time.LocalDate;

/**
 * Created by mac on 12/11/2019.
 */
public class NewStudentCmd {
	
	@NotBlank
	@Pattern ( regexp = "[pfPF](nd|ND)\\d{2}321\\d{3}")
	private String matricNo;
	@NotBlank
	private String password;
	private String surname;
	@NotBlank
	@Email
	private String email;
	
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
	
	public void setSurname ( String surname ) {
		this.surname = surname;
	}
	
	public void setEmail ( String email ) {
		this.email = email;
	}
	
	public String getSurname () {
		return surname;
	}
	
	public String getEmail () {
		return email;
	}
}
