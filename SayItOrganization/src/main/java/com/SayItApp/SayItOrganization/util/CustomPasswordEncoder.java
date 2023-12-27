package com.SayItApp.SayItOrganization.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.security.crypto.password.PasswordEncoder;

@Component
public class CustomPasswordEncoder  {
    private PasswordEncoder passwordEncoder;

    public CustomPasswordEncoder () {
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public PasswordEncoder getPasswordEncoder() {
        return passwordEncoder;
    }
}
