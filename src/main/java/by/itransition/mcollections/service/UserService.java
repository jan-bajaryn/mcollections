package by.itransition.mcollections.service;

import by.itransition.mcollections.entity.User;
import by.itransition.mcollections.repos.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepo userRepo;

    public boolean save(User user) {
        User save = userRepo.save(user);
        return save.getId() != null;
    }

}
