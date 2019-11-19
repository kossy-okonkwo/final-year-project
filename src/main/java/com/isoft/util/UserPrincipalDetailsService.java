package com.isoft.util;

import com.isoft.student.Student;
import com.isoft.student.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserPrincipalDetailsService implements UserDetailsService {

    @Autowired
    private StudentRepository studentRepo;

    @Override
    public UserDetails loadUserByUsername(String matricNo) throws UsernameNotFoundException {

        Student s = studentRepo.findStudentByMatricNo (matricNo);

        if(s==null)
            throw new UsernameNotFoundException ("User 404");

        return new UserPrincipalDetails (s);
    }
}