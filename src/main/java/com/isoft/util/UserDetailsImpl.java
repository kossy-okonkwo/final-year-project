package com.isoft.util;

import com.isoft.admin.Admin;
import com.isoft.student.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

public class UserDetailsImpl implements UserDetails {

    private final Student student;
    private final Admin admin;
    
    @Autowired
    public UserDetailsImpl ( Student student, Admin admin ){
        this.student = student;
        this.admin = admin;
    }
    
    
    @Override
    public Collection<? extends GrantedAuthority > getAuthorities() {
        Collection<GrantedAuthority > authorities = new ArrayList<>();
        GrantedAuthority grantedAuthority = student != null
              ? new SimpleGrantedAuthority ("ROLE_" + student.getRole())
              : new SimpleGrantedAuthority ("ROLE_" + admin.getRole());
        authorities.add(grantedAuthority);
        return authorities;
    }
    
    public long getId () {
        return student!=null
              ? student.getId ()
              : admin.getId ();
    }
    
    public boolean isUserActive () {
        return admin != null && ! admin.getActive ();
    }
    
    public String getEmail() {
        return student!=null
              ? student.getEmail ()
              : admin.getEmail ();
    }
    
    public Roles getRole() {
        return student!=null
              ? student.getRole ()
              : admin.getRole ();
    }
    
    @Override
    public String getPassword() {
        return student != null
              ? student.getPassword()
              : admin.getPassword ();
    }
    
    @Override
    public String getUsername() {
        return student!=null
              ? student.getMatricNo ()
              : admin.getUsername ();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
//        return student!=null
//              ? student.getActive ()
//              : admin.getActive ();
        return true;
    }
}
