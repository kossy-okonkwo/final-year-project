package com.isoft.admin;

import com.isoft.util.Roles;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

/**
 * Created by mac on 03/12/2019.
 */
@Entity
@Audited
public class Admin {
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private Long id;
	@Column (unique = true)
	@NotNull
	private String username;
	private String password;
	@NotNull
	private String surname;
	@NotNull
	private String email;
	@NotNull
	private LocalDate createdOn;
	@NotNull
	private LocalDate updatedOn;
	@NotNull
	private Boolean active;
	@Enumerated(EnumType.STRING)
	@NotNull
	private Roles role;
	
	public Admin () {
	}
	
	public Admin ( @NotNull String username,@NotNull String password, @NotNull String surname, @NotNull String email) {
		this.username = username;
		this.password = password;
		this.surname = surname;
		this.email = email;
		this.createdOn = LocalDate.now ();
		this.updatedOn = LocalDate.now ();
		this.active = true;
		this.role = Roles.ADMIN;
	}
	
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
	
	public LocalDate getCreatedOn () {
		return createdOn;
	}
	
	public void setCreatedOn ( LocalDate createdOn ) {
		this.createdOn = createdOn;
	}
	
	public LocalDate getUpdatedOn () {
		return updatedOn;
	}
	
	public void setUpdatedOn ( LocalDate updatedOn ) {
		this.updatedOn = updatedOn;
	}
	
	public Boolean getActive () {
		return active;
	}
	
	public void setActive ( Boolean active ) {
		this.active = active;
	}
	
	public Roles getRole () {
		return role;
	}
	
	public void setRole ( Roles Roles ) {
		this.role = role;
	}
	
	@Override
	public String toString () {
		return "Admin{" +
			  "id=" + id +
			  ", username='" + username + '\'' +
			  ", password='" + password + '\'' +
			  ", surname='" + surname + '\'' +
			  ", email='" + email + '\'' +
			  ", createdOn=" + createdOn +
			  ", updatedOn=" + updatedOn +
			  ", active=" + active +
			  ", role=" + role +
			  '}';
	}
}
