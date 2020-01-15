package com.isoft.event;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EventController {
	
	@GetMapping("/new-event")
	public String createEvent(Model model){
		model.addAttribute ( "event", new Event() );
		return "new-event";
	}
	
	@GetMapping("/edit-event")
	public String editEvent(Model model){
		model.addAttribute ( "event", new Event() );
		return "new-event";
	}
	
	@GetMapping("/delete-event")
	public String deleteEvent(Model model){
		model.addAttribute ( "event", new Event() );
		return "new-event";
	}
}
