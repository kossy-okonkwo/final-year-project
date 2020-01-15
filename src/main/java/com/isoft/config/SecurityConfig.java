package com.isoft.config;


import com.isoft.util.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
//@EnableOAuth2Sso
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsServiceImpl userPrincipalDetailsService;

    
    @Override
    protected void configure(AuthenticationManagerBuilder auth) {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider ();
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        daoAuthenticationProvider.setUserDetailsService(userPrincipalDetailsService);
        auth.authenticationProvider(daoAuthenticationProvider);
    }
    

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .requestMatchers ( PathRequest.toStaticResources ().atCommonLocations () ).permitAll ()
                .antMatchers("/").authenticated()
                .antMatchers("/all-**").authenticated()
                .antMatchers("/student-list").authenticated()
                .antMatchers("/**-event").authenticated()
                .antMatchers("/login").permitAll()
                .antMatchers("/register").permitAll()
                .antMatchers("/login-admin").permitAll()
                .antMatchers("/register-admin").hasRole ( "ADMIN" )
                .and()
                .formLogin()
                .loginPage("/login")
                .and()
                .logout()
                .deleteCookies("JSESSIONID")
                .logoutUrl("/logout").logoutSuccessUrl("/login");
    }

    @Bean
	PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder ();
    }
    
   
}