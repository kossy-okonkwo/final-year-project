package com.isoft.student;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.isoft.config.Messages;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import javax.validation.Valid;

@Controller
public class StudentController {
	
	private final StudentService studentService;
	private final Messages messages;
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	public StudentController ( StudentService studentService, Messages messages ) {
		this.studentService = studentService;
		this.messages = messages;
	}
	
	@GetMapping ("/register")
	public String getStudentRegistrationPage(Model model) {
		model.addAttribute ( "student",new Student () );
		return "register";
	}
	
	@PostMapping("/register")
	public String registerStudent(@ModelAttribute("student") @Valid NewStudentCmd cmd, BindingResult result, RedirectAttributes redirectAttributes) {
		if(cmd == null) throw new RuntimeException ("Invalid Data");
		studentService.checkMatricNoOrEmailExist ( cmd, result );
		if (result.hasErrors()) {
			logger.warn("Error occurred creating Student {}", result.getAllErrors ());
			return "register";
		}
		studentService.createStudent (cmd);
		redirectAttributes.addFlashAttribute("message", messages.get("student.added.ok"));
		return "redirect:/";
	}
	
	@GetMapping ("/all-student")
	public String getAllStudentsPage() {
		return "all-student";
	}
	
	@GetMapping ("/all-subject")
	public String getAllSubjectsPage() {
		return "all-subject";
	}
	
	@GetMapping ("/all-teacher")
	public String getAllTeachersPage() {
		return "all-teacher";
	}
	
	@GetMapping ("/all-class")
	public String getAllClassPage() {
		return "all-class";
	}
	
	@GetMapping ("/all-book")
	public String getAllBooksPage() {
		return "all-book";
	}
	
}
