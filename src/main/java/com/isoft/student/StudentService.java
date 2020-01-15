package com.isoft.student;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.util.List;

public interface StudentService {
	void checkMatricNoOrEmailExist (NewStudentCmd cmd, BindingResult result);
	void createStudent(NewStudentCmd newStudentCmd);
	void modifyStudent(ModifyStudentCmd modifyStudentCmd);
	void deleteStudent(Long id);
	Student findStudentById(Long id);
	Student findStudentByMatricNo(String matricNo);
	List<Student> findAllStudents();
	Page<Student> findAllStudents (String pattern, Pageable pageable);
}
