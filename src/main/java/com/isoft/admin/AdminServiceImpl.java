package com.isoft.admin;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.isoft.config.Messages;
import com.isoft.util.AppUser;
import com.isoft.util.Roles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import java.time.LocalDate;

@Service
public class AdminServiceImpl implements AdminService {
	
	private final AdminRepository adminRepository;
	private final PasswordEncoder passwordEncoder;
	private final Messages messages;
	
	@Autowired
	public AdminServiceImpl ( AdminRepository adminRepository, PasswordEncoder passwordEncoder, Messages messages ) {
		this.adminRepository = adminRepository;
		this.passwordEncoder = passwordEncoder;
		this.messages = messages;
	}
	
	@Override
	public Admin findAdminById ( Long id ) {
		return adminRepository.getOne ( id );
	}
	
	@Override
	public void createAdmin ( NewAdminCmd newAdminCmd ) {
		Admin admin = new Admin (  );
		admin.setUsername ( newAdminCmd.getUsername () );
		admin.setPassword ( passwordEncoder.encode ( "password101" ) );
		admin.setEmail ( newAdminCmd.getEmail () );
		admin.setSurname ( newAdminCmd.getSurname () );
		admin.setCreatedOn ( LocalDate.now () );
		admin.setUpdatedOn ( LocalDate.now () );
		admin.setActive ( false );
		admin.setRole ( Roles.ADMIN );
		adminRepository.save ( admin );
	}
	
	@Override
	public void checkUsernameOrEmailExist ( NewAdminCmd cmd, BindingResult result ) {
		if ( adminRepository.findAll ().stream ().anyMatch ( admin ->
			  admin.getUsername ().equalsIgnoreCase ( cmd.getUsername () ) ) ) {
			result.addError ( new ObjectError ( "username", messages.get ( "Unnique.admin.username" ) ) );
		}
		if ( adminRepository.findAll ().stream ().anyMatch ( admin ->
			  admin.getEmail ().equalsIgnoreCase ( cmd.getEmail () ) ) ) {
			result.addError ( new ObjectError ( "email", messages.get ( "Unnique.admin.email" ) ) );
		}
	}
	
	@Override
	public boolean isFirstLogin () throws Exception{
//		System.out.println ( AppUser.getCurrentUser () );
//		UserDetailsImpl ud = (UserDetailsImpl ) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		System.out.printf ("account is locked %s\n", AppUser.getCurrentUser ().isUserActive ());
		ObjectMapper mapper = new ObjectMapper (  );
		System.out.println (mapper.writeValueAsString ( AppUser.getCurrentUser () ));
		System.out.println ( adminRepository.getOne ( AppUser.getCurrentUser ().getId () ).toString () );
		return AppUser.getCurrentUser ().isUserActive ();
	}
}
