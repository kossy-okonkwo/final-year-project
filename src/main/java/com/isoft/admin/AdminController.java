package com.isoft.admin;

import com.isoft.config.Messages;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import javax.validation.Valid;

/**
 * Created by mac on 03/12/2019.
 */
@Controller
public class AdminController {
	
	private final AdminService adminService;
	private final Messages messages;
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	public AdminController ( AdminService adminService, Messages messages ) {
		this.adminService = adminService;
		this.messages = messages;
	}
	
	@GetMapping ("/login")
	public String getLoginPage() {
		return "login";
	}
	
	@GetMapping("/")
	public String index(Model model) throws Exception {
		if(adminService.isFirstLogin ()) {
			model.addAttribute ( "newPassword", new ModifyAdminCmd () );
			return "password-change";
		}
		return "index";
	}
	
	@PostMapping("/password-change")
	public String changeAdminPassword(@ModelAttribute ("admin") @Valid ModifyAdminCmd cmd, BindingResult result, RedirectAttributes redirectAttributes){
//		redirectAttributes.addFlashAttribute("message", messages.get("admin.added.ok"));
		if (result.hasErrors()) {
			logger.warn("Error occurred creating Admin {}", result.getAllErrors ());
			return "password-change";
		}
		return "redirect:/";
	}
	
	@GetMapping ("/register-admin")
	public String getAdminRegistrationPage(Model model) {
		model.addAttribute ( "admin",new Admin () );
		return "register-admin";
	}
	
	@PostMapping ("/register-admin")
	public String registerAdmin(@ModelAttribute ("admin") @Valid NewAdminCmd cmd, BindingResult result, RedirectAttributes redirectAttributes) {
		if(cmd == null) throw new RuntimeException ("Invalid Data");
		adminService.checkUsernameOrEmailExist ( cmd, result );
		if (result.hasErrors()) {
			logger.warn("Error occurred creating Admin {}", result.getAllErrors ());
			return "register-admin";
		}
		adminService.createAdmin (cmd);
		redirectAttributes.addFlashAttribute("message", messages.get("admin.added.ok"));
		return "redirect:/";
	}
}
