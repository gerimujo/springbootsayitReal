package com.SayItApp.SayItOrganization.SecurityConfig;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.SayItApp.SayItOrganization.Filter.JwtFilter;
import com.SayItApp.SayItOrganization.util.CustomPasswordEncoder;

@EnableWebSecurity
@EnableGlobalMethodSecurity(
    securedEnabled = true,
    jsr250Enabled = true,
    prePostEnabled = true
)
public class SecurityConfig extends WebSecurityConfigurerAdapter{

    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private CustomPasswordEncoder customPasswordEncoder;
    @Autowired
    private JwtFilter jwtFilter;

  /*  @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        super.configure(auth);}

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        super.configure(http);
    }*/ 

   @Override @Bean
    public  AuthenticationManager authenticationManagerBean() throws Exception{
         return super.authenticationManagerBean();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // TODO Auto-generated method stub
        auth.userDetailsService(userDetailsService).passwordEncoder(customPasswordEncoder.getPasswordEncoder());
//auth.userDetailsService(null);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
        .cors().and() // Enable CORS
        .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
        .exceptionHandling().authenticationEntryPoint((request, response, ex) -> {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, ex.getMessage());
        }).and()
        .authorizeRequests()
        .antMatchers("/api/auth/**").permitAll()
        .anyRequest().authenticated();

    http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

     
    }
 
   


}
