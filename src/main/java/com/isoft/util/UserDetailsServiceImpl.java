package com.isoft.util;

import com.isoft.admin.Admin;
import com.isoft.admin.AdminRepository;
import com.isoft.student.Student;
import com.isoft.student.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Role;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final StudentRepository studentRepo;
    private final AdminRepository adminRepository;
    
    @Autowired
    public UserDetailsServiceImpl ( StudentRepository studentRepo, AdminRepository adminRepository ) {
        this.studentRepo = studentRepo;
        this.adminRepository = adminRepository;
    }
    
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        
        Student student = studentRepo.findStudentByMatricNo (s);
        Admin admin = adminRepository.findByUsername (s);
    
        if(student == null && admin == null) {
            throw new UsernameNotFoundException ("User 404");}
        return new UserDetailsImpl (student, admin);
//        UserDetailsImpl userDetails = new UserDetailsImpl ( student, admin );
//        return new org.springframework.security.core.userdetails.User(
//              userDetails.getUsername (),
//              userDetails.getPassword (),
//              userDetails.getAuthorities ());
    }
}