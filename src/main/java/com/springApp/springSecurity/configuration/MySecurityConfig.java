package com.springApp.springSecurity.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.sql.DataSource;

@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {
    // write userName, pass and ROLES for application

    @Autowired
    private DataSource dataSource;
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.jdbcAuthentication().dataSource(dataSource);
//        UserBuilder userBuilder = User.withDefaultPasswordEncoder();
//
//        auth.inMemoryAuthentication()
//                .withUser(userBuilder.username("zaur").password("zaur").roles("EMPLOYEE"))
//                .withUser(userBuilder.username("elena").password("elena").roles("HR"))
//                .withUser(userBuilder.username("ivan").password("ivan").roles("MANAGER","HR", "EMPLOYEE"));

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/").hasAnyRole("EMPLOYEE", "HR", "MANAGER")
                .antMatchers("/hr-info").hasRole("HR")
                .antMatchers("/manager-info/**").hasRole("MANAGER")
                .and().formLogin().permitAll();
    }
}
