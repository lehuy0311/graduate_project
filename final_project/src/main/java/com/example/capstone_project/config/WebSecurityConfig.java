package com.example.capstone_project.config;

import com.example.capstone_project.service.customer.impl.UserDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.rememberme.InMemoryTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailServiceImpl userDetailsService;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder;
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {

        // Set up the service to search for User in the Database.
        // And set the PasswordEncoder.
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable();

        // Pages that do not require login
        http.authorizeRequests().antMatchers("/index", "/account/login", "/account/logout").permitAll();

        // The /userInfo page requires login with the ROLE_USER or ROLE_ADMIN role.
        // If not logged in, it will redirect to the /login page.
        http.authorizeRequests().antMatchers("/userInfo", "/user/detail").access("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')");

        // Admin-only pages
        http.authorizeRequests().antMatchers("/admin/*","/createAnimal","/deleteAnimal","/updateAnimal/{id}","/delete","/create","/create-form","/{id}/update","/{id}/update").access("hasRole('ROLE_ADMIN')");

        // If the logged-in user tries to access a page without sufficient permissions,
        // an AccessDeniedException will be thrown.
        http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/403");

        // Configure the Login Form.
        http.authorizeRequests().and().formLogin()
                .loginPage("/account/login")
                .loginProcessingUrl("/j_spring_security_check") // Submit URL
                .defaultSuccessUrl("/home/success")//
                .failureUrl("/account/login?error=true")//
                .usernameParameter("username")//
                .passwordParameter("password")
                // Configure the Logout Page.
                .and().logout().logoutUrl("/account/logout").logoutSuccessUrl("/account/login");

        // Configure Remember Me.
        http.authorizeRequests().and() //
                .rememberMe().tokenRepository(this.persistentTokenRepository()) //
                .tokenValiditySeconds(1 * 24 * 60 * 60); // 24 hours

    }

    @Bean
    public PersistentTokenRepository persistentTokenRepository() {
        InMemoryTokenRepositoryImpl memory = new InMemoryTokenRepositoryImpl();
        return memory;
    }

}