package com.isoft;

import com.isoft.admin.Admin;
import com.isoft.admin.AdminRepository;
import com.isoft.student.Student;
import com.isoft.student.StudentRepository;
import com.isoft.util.Roles;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Arrays;

@SpringBootApplication
public class SchoolCalendarApplication implements InitializingBean {

	private final StudentRepository studentRepo;
	private final AdminRepository adminRepository;
	private final PasswordEncoder passwordEncoder;
	private Logger logger = LoggerFactory.getLogger ( this.getClass () );
	
	@Autowired
	public SchoolCalendarApplication ( StudentRepository studentRepo, AdminRepository adminRepository, PasswordEncoder passwordEncoder ) {
		this.studentRepo = studentRepo;
		this.adminRepository = adminRepository;
		this.passwordEncoder = passwordEncoder;
	}
	
	public static void main(String[] args) {
		SpringApplication.run( SchoolCalendarApplication.class, args);
	}
	
	@Override
	public void afterPropertiesSet () throws Exception {
		if(studentRepo.findAll ().isEmpty ()) {
			Student std1 = new Student ( "PND16321001",passwordEncoder.encode ( "." ),"Kossy","kossy@test.com" );
			Student std2 = new Student ( "FND16321002",passwordEncoder.encode ( "." ), "ISoft","isoft@admin.com" );
			studentRepo.saveAll ( Arrays.asList (std1,std2) );
			logger.info ( "DB Init Users Created With Matric Numbers And SU : {}, {}",std1.getMatricNo (),std2.getMatricNo () );
		}
		if(adminRepository.findAll ().isEmpty ()) {
			adminRepository.save ( new Admin ( "SU", passwordEncoder.encode ( "." ), "Admin", "isoft@test.com" ) );
			logger.info ( "DB Init SU User Created" );
		}
	}
}
