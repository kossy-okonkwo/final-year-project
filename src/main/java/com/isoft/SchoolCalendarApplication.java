package com.isoft;

import com.isoft.student.Student;
import com.isoft.student.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@SpringBootApplication
public class SchoolCalendarApplication implements InitializingBean {

	private final StudentRepository studentRepo;
	private final PasswordEncoder passwordEncoder;
	private Logger logger = LoggerFactory.getLogger ( this.getClass () );
	
	@Autowired
	public SchoolCalendarApplication ( StudentRepository studentRepo, PasswordEncoder passwordEncoder ) {
		this.studentRepo = studentRepo;
		this.passwordEncoder = passwordEncoder;
	}
	
	public static void main(String[] args) {
		SpringApplication.run( SchoolCalendarApplication.class, args);
	}
	
	@Override
	public void afterPropertiesSet () throws Exception {
		if(studentRepo.findAll ().isEmpty ()) {
			Student std1 = new Student ( "Kossy001",passwordEncoder.encode ( "1234" ) );
			Student std2 = new Student ( "Paul001",passwordEncoder.encode ( "1234" ) );
			studentRepo.saveAll ( Arrays.asList (std1,std2) );
			logger.info ( "DB Init Users Created With Matric Numbers : {}, User2 {}",std1.getMatricNo (),std2.getMatricNo () );
		}
	}
}
