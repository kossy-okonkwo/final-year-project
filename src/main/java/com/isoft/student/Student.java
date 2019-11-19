package com.isoft.student;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

/**
 * Created by mac on 04/11/2019.
 */
@Entity
public class Student {
	
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private Long id;
	private String matricNo;
	private String password;
	private LocalDate createdOn;
	private Boolean active = true;
	private String role;
	
	public Student () {
	}
	
	public Student ( String matricNo, String password ) {
		this.matricNo = matricNo;
		this.password = password;
	}
	
	public Long getId () {
		return id;
	}
	
	public void setId ( Long id ) {
		this.id = id;
	}
	
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
