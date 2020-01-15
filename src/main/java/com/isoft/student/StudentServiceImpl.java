package com.isoft.student;

import com.isoft.config.Messages;
import com.isoft.util.Roles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import java.time.LocalDate;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
	
	private final StudentRepository studentRepository;
	private final PasswordEncoder passwordEncoder;
	private final Messages messages;
	
	@Autowired
	public StudentServiceImpl ( StudentRepository studentRepository, PasswordEncoder passwordEncoder, Messages messages ) {this.studentRepository = studentRepository;
		this.passwordEncoder = passwordEncoder;
		this.messages = messages;
	}
	
	@Override
	public void checkMatricNoOrEmailExist (NewStudentCmd cmd, BindingResult result ) {
		if ( studentRepository.findAll ().stream ().anyMatch ( student ->
			  student.getMatricNo ().equalsIgnoreCase ( cmd.getMatricNo () ) ) ) {
			result.addError ( new ObjectError ( "matricNo", messages.get ( "Unnique.student.matricNo" ) ) );
		}
		if ( studentRepository.findAll ().stream ().anyMatch ( student ->
			  student.getEmail ().equalsIgnoreCase ( cmd.getEmail () ) ) ) {
			result.addError ( new ObjectError ( "email", messages.get ( "Unnique.student.email" ) ) );
		}
	}
	
	@Override
	public void createStudent ( NewStudentCmd newStdCmd ) {
		Student student = new Student (  );
		student.setMatricNo ( newStdCmd.getMatricNo() );
		student.setPassword ( passwordEncoder.encode ( newStdCmd.getPassword () ) );
		student.setEmail ( newStdCmd.getEmail () );
		student.setSurname ( newStdCmd.getSurname () );
		student.setCreatedOn ( LocalDate.now () );
		student.setUpdatedOn ( LocalDate.now () );
		student.setActive ( true );
		student.setRole ( Roles.STUDENT );
		studentRepository.save ( student );
	}
	
	@Override
	public void modifyStudent ( ModifyStudentCmd modStdCmd ) {
		Student student = new Student (  );
		student.setMatricNo ( modStdCmd.getMatricNo () );
		student.setPassword ( passwordEncoder.encode ( modStdCmd.getPassword () ) );
		studentRepository.save ( student );
	}
	
	@Override
	public void deleteStudent ( Long id ) {
		Student student = studentRepository.findStudentById ( id );
		studentRepository.delete ( student );
	}
	
	@Override
	public Student findStudentById ( Long id ) {
		return studentRepository.findStudentById ( id );
	}
	
	@Override
	public Student findStudentByMatricNo ( String matricNo ) {
		return studentRepository.findStudentByMatricNo ( matricNo );
	}
	
	@Override
	public List<Student> findAllStudents () {
		return studentRepository.findAll ();
	}
	
	@Override
	public Page<Student> findAllStudents (String pattern, Pageable page) {
		return studentRepository.findAll ( page );
	}
}
