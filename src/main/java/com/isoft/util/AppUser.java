package com.isoft.util;

import com.isoft.admin.Admin;
import com.isoft.admin.AdminRepository;
import com.isoft.student.Student;
import com.isoft.student.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

//@Component
public class AppUser {
	
	private static AdminRepository adminRepository;
	private static StudentRepository studentRepository;
	@Autowired
	public AppUser ( AdminRepository adminRepository, StudentRepository studentRepository ) {
		AppUser.adminRepository = adminRepository;
		AppUser.studentRepository = studentRepository;
	}
	
	public static UserDetailsImpl getCurrentUser() {
//		User currentUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return (UserDetailsImpl)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//
//		UserDetailsImpl ud = (UserDetailsImpl ) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//		Admin adminUser = adminRepository.findByUsername ( ud.getUsername () );
//		if (adminUser != null)
//			return adminUser;
//	  	Student studentUser = studentRepository.findStudentByMatricNo ( ud.getUsername () );
//		if (studentUser != null)
//			return studentUser;
//		throw new RuntimeException ( "No User In Session" );
	}
}
