package com.isoft.util;

import com.isoft.student.Student;
import com.isoft.util.Roles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

public class UserPrincipalDetails implements UserDetails {

    @Autowired
    private Student student;

    public UserPrincipalDetails (Student student){
        this.student = student;
    }

    @Override
    public Collection<? extends GrantedAuthority > getAuthorities() {
        Collection<GrantedAuthority > authorities = new ArrayList<>();
        GrantedAuthority grantedAuthority = new SimpleGrantedAuthority ("ROLE_" + Roles.getRole ());
        authorities.add(grantedAuthority);
        return authorities;
    }

    @Override
    public String getPassword() {
        return student.getPassword();
    }

    @Override
    public String getUsername() {
        return student.getMatricNo ();
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
        return student.getActive();
    }
}
