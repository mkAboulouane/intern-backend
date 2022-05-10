package fst.sir.com.security.config;

import fst.sir.com.security.common.AuthoritiesConstants;
import fst.sir.com.security.jwt.JWTAuthenticationFilter;
import fst.sir.com.security.jwt.JWTAuthorizationFiler;
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
        http.authorizeRequests().antMatchers("/login").permitAll();
        http.authorizeRequests().antMatchers("/actuator/health").permitAll();
        http.authorizeRequests().antMatchers("/actuator/info").permitAll();

        http.authorizeRequests().antMatchers("/api/admin/login").permitAll();
        http.authorizeRequests().antMatchers("/api/chercheur/login").permitAll();
        http.authorizeRequests().antMatchers("/api/admin/").hasAnyAuthority(AuthoritiesConstants.ADMIN);
        http.authorizeRequests().antMatchers("/api/chercheur/").hasAnyAuthority(AuthoritiesConstants.CLIENT);

        http.addFilter(new JWTAuthenticationFilter(authenticationManager()));
        http.addFilterBefore(new JWTAuthorizationFiler(), UsernamePasswordAuthenticationFilter.class);
    }

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

}