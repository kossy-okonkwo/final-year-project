package com.isoft.student;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

/**
 * Created by mac on 12/11/2019.
 */
public class ModifyStudentCmd {
	@NotEmpty
	private String matricNo;
	@Min ( value = 6)
	@NotBlank
	private String password;
	private LocalDate createdOn;
	private Boolean active = true;
	private String role;
	
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
	
	public LocalDate getCreatedOn () {
		return createdOn;
	}
	
	public void setCreatedOn ( LocalDate createdOn ) {
		this.createdOn = createdOn;
	}
	
	public Boolean getActive () {
		return active;
	}
	
	public void setActive ( Boolean active ) {
		this.active = active;
	}
	
	public String getRole () {
		return role;
	}
	
	public void setRole ( String role ) {
		this.role = role;
	}
}
