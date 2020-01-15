package com.isoft.event;

import org.hibernate.envers.Audited;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

/**
 * Created by mac on 03/12/2019.
 */
@Audited
@Entity
public class Event {
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private Long id;
	@NotBlank
	private String eventTitle;
	@NotBlank
	private String eventDetails;
	@NotNull
	private LocalDate eventDate;
	@NotNull
	private Long postedById;
	@NotBlank
	private String postedByName;
	
	public Event(){}
	
	public Event(String eventTitle) {}
	
	public Long getId () {
		return id;
	}
	
	public void setId ( Long id ) {
		this.id = id;
	}
	
	public String getEventTitle () {
		return eventTitle;
	}
	
	public void setEventTitle ( String eventTitle ) {
		this.eventTitle = eventTitle;
	}
	
	public LocalDate getEventDate () {
		return eventDate;
	}
	
	public void setEventDate ( LocalDate eventDate ) {
		this.eventDate = eventDate;
	}
	
	public Long getPostedById () {
		return postedById;
	}
	
	public void setPostedById ( Long postedById ) {
		this.postedById = postedById;
	}
	
	public String getPostedByName () {
		return postedByName;
	}
	
	public void setPostedByName ( String postedByName ) {
		this.postedByName = postedByName;
	}
	
	public String getEventDetails () {
		return eventDetails;
	}
	
	public void setEventDetails ( String eventDetails ) {
		this.eventDetails = eventDetails;
	}
	
	@Override
	public boolean equals ( Object o ) {
		if ( this == o ) return true;
		if ( o == null || getClass () != o.getClass () ) return false;
		
		Event event = ( Event ) o;
		
		if ( id != null ? ! id.equals ( event.id ) : event.id != null ) return false;
		if ( eventTitle != null ? ! eventTitle.equals ( event.eventTitle ) : event.eventTitle != null ) return false;
		if ( eventDetails != null ? ! eventDetails.equals ( event.eventDetails ) : event.eventDetails != null )
			return false;
		if ( eventDate != null ? ! eventDate.equals ( event.eventDate ) : event.eventDate != null ) return false;
		if ( postedById != null ? ! postedById.equals ( event.postedById ) : event.postedById != null ) return false;
		return postedByName != null ? postedByName.equals ( event.postedByName ) : event.postedByName == null;
	}
	
	@Override
	public int hashCode () {
		int result = id != null ? id.hashCode () : 0;
		result = 31 * result + ( eventTitle != null ? eventTitle.hashCode () : 0 );
		result = 31 * result + ( eventDetails != null ? eventDetails.hashCode () : 0 );
		result = 31 * result + ( eventDate != null ? eventDate.hashCode () : 0 );
		result = 31 * result + ( postedById != null ? postedById.hashCode () : 0 );
		result = 31 * result + ( postedByName != null ? postedByName.hashCode () : 0 );
		return result;
	}
	
	@Override
	public String toString () {
		return "Event{" +
			  "id=" + id +
			  ", eventTitle='" + eventTitle + '\'' +
			  ", eventDetails='" + eventDetails + '\'' +
			  ", eventDate=" + eventDate +
			  ", postedById=" + postedById +
			  ", postedByName='" + postedByName + '\'' +
			  '}';
	}
}
