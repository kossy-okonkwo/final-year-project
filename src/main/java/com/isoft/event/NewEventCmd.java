package com.isoft.event;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

/**
 * Created by mac on 03/12/2019.
 */
public class NewEventCmd {
	@NotBlank
	private String eventTitle;
	@NotBlank
	private String eventDetails;
	@NotNull
	private LocalDate eventDate;
	
	public String getEventTitle () {
		return eventTitle;
	}
	
	public void setEventTitle ( String eventTitle ) {
		this.eventTitle = eventTitle;
	}
	
	public String getEventDetails () {
		return eventDetails;
	}
	
	public void setEventDetails ( String eventDetails ) {
		this.eventDetails = eventDetails;
	}
	
	public LocalDate getEventDate () {
		return eventDate;
	}
	
	public void setEventDate ( LocalDate eventDate ) {
		this.eventDate = eventDate;
	}
}
