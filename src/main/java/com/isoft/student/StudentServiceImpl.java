package com.isoft.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import java.util.List;

public class StudentServiceImpl implements StudentService {
	
	private final StudentRepository studentRepo;
	private final PasswordEncoder passwordEncoder;
	
	@Autowired
	public StudentServiceImpl ( StudentRepository studentRepo, PasswordEncoder passwordEncoder ) {this.studentRepo = studentRepo;
		this.passwordEncoder = passwordEncoder;
	}
	
	@Override
	public void createEntity ( NewStudentCmd newStdCmd ) {
		Student s = new Student (  );
		s.setMatricNo ( newStdCmd.getMatricNo() );
		s.setPassword ( passwordEncoder.encode ( newStdCmd.getPassword () ) );
		studentRepo.save ( s );
	}
	
	@Override
	public void modifyEntity ( ModifyStudentCmd modStdCmd ) {
		Student s = new Student (  );
		s.setMatricNo ( modStdCmd.getMatricNo () );
		s.setPassword ( passwordEncoder.encode ( modStdCmd.getPassword () ) );
		studentRepo.save ( s );
	}
	
	@Override
	public void deleteStudent ( Long id ) {
		Student s = studentRepo.findStudentById ( id );
		studentRepo.delete ( s );
	}
	
	@Override
	public Student findStudent ( Long id ) {
		return studentRepo.findStudentById ( id );
	}
	
	@Override
	public List< Student > findAllStudents () {
		return studentRepo.findAll ();
	}
	
	@Override
	public Page<Student> findAllStudents (Pageable page) {
		return studentRepo.findAll ( page );
	}
}
