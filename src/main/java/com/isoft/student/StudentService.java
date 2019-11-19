package com.isoft.student;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {
	void createEntity(NewStudentCmd s);
	void modifyEntity(ModifyStudentCmd s);
	void deleteStudent(Long id);
	Student findStudent(Long id);
	List<Student> findAllStudents();
	Page<Student> findAllStudents (Pageable pattern);
}
