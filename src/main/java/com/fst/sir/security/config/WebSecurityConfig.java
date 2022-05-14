package com.fst.sir.security.config;

import com.fst.sir.security.common.AuthoritiesConstants;
import com.fst.sir.security.jwt.JWTAuthenticationFilter;
import com.fst.sir.security.jwt.JWTAuthorizationFiler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(
        prePostEnabled = true,
        securedEnabled = true,
        jsr250Enabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.authorizeRequests().antMatchers("/").permitAll();

/*
        http.authorizeRequests().antMatchers("/login").permitAll();
        http.authorizeRequests().antMatchers("/regsiter").permitAll();
        http.authorizeRequests().antMatchers("/formations").permitAll();
        http.authorizeRequests().antMatchers("/congres-seminaires").permitAll();
        http.authorizeRequests().antMatchers("/materiel-biomedical").permitAll();
        http.authorizeRequests().antMatchers("/study-abroad").permitAll();
        http.authorizeRequests().antMatchers("/contact").permitAll();*/

        http.authorizeRequests().antMatchers("/admin/**").hasAnyAuthority(AuthoritiesConstants.ADMIN);
        http.authorizeRequests().antMatchers("/gerant/**").hasAnyAuthority(AuthoritiesConstants.GERANT);
        http.authorizeRequests().antMatchers("/app/**").hasAnyAuthority(AuthoritiesConstants.CLIENT);

        http.addFilter(new JWTAuthenticationFilter(authenticationManager()));
        http.addFilterBefore(new JWTAuthorizationFiler(), UsernamePasswordAuthenticationFilter.class);
    }

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

}