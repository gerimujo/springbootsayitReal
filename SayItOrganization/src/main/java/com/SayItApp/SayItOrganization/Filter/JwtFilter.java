package com.SayItApp.SayItOrganization.Filter;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import com.SayItApp.SayItOrganization.Repository.UserReprository;
import com.SayItApp.SayItOrganization.util.JwtUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Component
public class JwtFilter extends OncePerRequestFilter {

    @Autowired
private UserReprository userRepo;

@Autowired
private JwtUtil jwtTokenUtil;

public JwtFilter(){

}
    public JwtFilter(JwtUtil jwtTokenUtil,
                          UserReprository userRepo) {
        this.jwtTokenUtil = jwtTokenUtil;
        this.userRepo = userRepo;
        System.out.println("ndohdi nje eroorr1");

    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain chain)
            throws ServletException, IOException {
        // Get authorization header and validate


        final String header = request.getHeader(HttpHeaders.AUTHORIZATION);
        if ( !StringUtils.hasText(header) || !header.startsWith("Bearer")) {
        
            chain.doFilter(request, response);
            return;
        }
                final String token = header.split(" ")[1].trim();


     UserDetails userDetails = userRepo
            .findByUsername(jwtTokenUtil.getUsernameFromToken(token))
            .orElse(null);
        //Get jwt token and validate
        if (!jwtTokenUtil.validateToken(token,userDetails)) {
          System.out.println("ndohdi nje eroorr4444444444444443333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333333");

            chain.doFilter(request, response);
            return;
        }
        // Get user identity and set it on the spring security context
   

        UsernamePasswordAuthenticationToken
            authentication = new UsernamePasswordAuthenticationToken(
                userDetails, null,
                userDetails == null ?
                
                   Arrays.asList() : userDetails.getAuthorities()
                  
            );
System.out.println("Authorities: " + userDetails.getAuthorities().stream()
        .map(Object::toString)
        .collect(Collectors.joining(", ")));    
            authentication.setDetails(
            new WebAuthenticationDetailsSource().buildDetails(request)
        );


        SecurityContextHolder.getContext().setAuthentication(authentication);
        chain.doFilter(request, response);
    }
    
}
