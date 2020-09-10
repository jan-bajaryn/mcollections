package by.itransition.mcollections.service;

import by.itransition.mcollections.entity.Role;
import by.itransition.mcollections.entity.User;
import by.itransition.mcollections.repos.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final PasswordEncoder passwordEncoder;
    private final UserRepo userRepo;

    public boolean registration(User user) {
        if (user != null) {
            modifyRegistration(user);
            return userRepo.save(user).getId() != null;
        }
        return false;
    }

    private void modifyRegistration(User user) {
        user.setRole(Role.CLIENT);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
    }

}
