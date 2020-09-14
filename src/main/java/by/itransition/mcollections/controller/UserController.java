package by.itransition.mcollections.controller;

import by.itransition.mcollections.entity.User;
import by.itransition.mcollections.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    private final UserService userService;

    @PostMapping(value = "/sign-up")
    public boolean signUp(@RequestBody User user) {
        return userService.registration(user);
    }

}
