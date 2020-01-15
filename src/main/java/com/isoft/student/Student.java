package com.isoft.student;

import com.isoft.util.Roles;
import org.hibernate.envers.Audited;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

/**
 * Created by mac on 04/11/2019.
 */
@Audited
@Entity
public class Student {
	
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private Long id;
	@Column(unique = true)
	@NotNull
	private String matricNo;
	@NotNull
	private String password;
	private String surname;
	@NotNull
	@Column(unique = true)
	private String email;
	@NotNull
	private LocalDate createdOn;
	@NotNull
	private LocalDate updatedOn;
	@NotNull
	private Boolean active = true;
	@Enumerated(EnumType.STRING)
	@NotNull
	private Roles role;
	
	public Student () {
	}
	
	public Student ( String matricNo, String password, String surname, String email ) {
		this.matricNo = matricNo;
		this.password = password;
		this.surname = surname;
		this.email = email;
		this.createdOn = LocalDate.now ();
		this.updatedOn = LocalDate.now ();
		this.active = true;
		this.role = Roles.STUDENT;
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
	
	public Roles getRole () {
		return role;
	}
	
	public void setRole ( Roles role ) {
		this.role = role;
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
	
	@Override
	public boolean equals ( Object o ) {
		if ( this == o ) return true;
		if ( o == null || getClass () != o.getClass () ) return false;
		
		Student student = ( Student ) o;
		
		if ( id != null ? ! id.equals ( student.id ) : student.id != null ) return false;
		if ( matricNo != null ? ! matricNo.equals ( student.matricNo ) : student.matricNo != null ) return false;
		if ( password != null ? ! password.equals ( student.password ) : student.password != null ) return false;
		if ( surname != null ? ! surname.equals ( student.surname ) : student.surname != null ) return false;
		if ( email != null ? ! email.equals ( student.email ) : student.email != null ) return false;
		if ( createdOn != null ? ! createdOn.equals ( student.createdOn ) : student.createdOn != null ) return false;
		if ( updatedOn != null ? ! updatedOn.equals ( student.updatedOn ) : student.updatedOn != null ) return false;
		if ( active != null ? ! active.equals ( student.active ) : student.active != null ) return false;
		return role != null ? role.equals ( student.role ) : student.role == null;
	}
	
	@Override
	public int hashCode () {
		int result = id != null ? id.hashCode () : 0;
		result = 31 * result + ( matricNo != null ? matricNo.hashCode () : 0 );
		result = 31 * result + ( password != null ? password.hashCode () : 0 );
		result = 31 * result + ( surname != null ? surname.hashCode () : 0 );
		result = 31 * result + ( email != null ? email.hashCode () : 0 );
		result = 31 * result + ( createdOn != null ? createdOn.hashCode () : 0 );
		result = 31 * result + ( updatedOn != null ? updatedOn.hashCode () : 0 );
		result = 31 * result + ( active != null ? active.hashCode () : 0 );
		result = 31 * result + ( role != null ? role.hashCode () : 0 );
		return result;
	}
	
	@Override
	public String toString () {
		return "Student{" +
			  "id=" + id +
			  ", matricNo='" + matricNo + '\'' +
			  ", password='" + password + '\'' +
			  ", surname='" + surname + '\'' +
			  ", email='" + email + '\'' +
			  ", createdOn=" + createdOn +
			  ", updatedOn=" + updatedOn +
			  ", active=" + active +
			  ", role='" + role + '\'' +
			  '}';
	}
}
