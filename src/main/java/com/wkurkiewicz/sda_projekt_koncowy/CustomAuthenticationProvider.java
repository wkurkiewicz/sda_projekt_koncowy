package com.wkurkiewicz.sda_projekt_koncowy;
import com.wkurkiewicz.sda_projekt_koncowy.model.User;
import com.wkurkiewicz.sda_projekt_koncowy.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
@Slf4j
@AllArgsConstructor
public class CustomAuthenticationProvider implements AuthenticationProvider {

    private final UserRepository userRepository;

    private final PasswordEncoder encoder;


    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();
        User byUsername = userRepository.findByUsername(username);
        log.info(byUsername.toString());
        if (byUsername == null) {
            throw new IllegalArgumentException("Details not found");
        }
        if (encoder.matches(password, byUsername.getPassword())) {
            String role = byUsername.getUserType().toString(); // to zwróci enuma ADMINISTRATOR
            // List<String> authorities = Arrrays.asList(role)
            SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(role);
            List<GrantedAuthority> grantedAuthorityList = Arrays.asList(simpleGrantedAuthority);
            return new UsernamePasswordAuthenticationToken(username, password, grantedAuthorityList);
        } else {
            throw new IllegalArgumentException("Password mismatch");
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }

}