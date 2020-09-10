package by.itransition.mcollections.service;

import by.itransition.mcollections.repos.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class JwtUserDetailsService implements UserDetailsService {

    private final UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        by.itransition.mcollections.entity.User byUsername = userRepo.findByUsername(username);
        if (byUsername != null) {
            return byUsername;
        } else {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
    }
}