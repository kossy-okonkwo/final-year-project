package com.isoft.student;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

/**
 * Created by mac on 04/11/2019.
 */
@Controller
public class StudentController {
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping ("/login")
	public String getLoginPage() {
		return "login";
	}
	
}
