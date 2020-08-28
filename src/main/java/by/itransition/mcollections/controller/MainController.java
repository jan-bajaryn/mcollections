package by.itransition.mcollections.controller;

import by.itransition.mcollections.entity.User;
import by.itransition.mcollections.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MainController {

    private final UserMapper userMapper;

    @GetMapping("/")
    public Object index() {
        User user = new User();
        user.setId(1);
        user.setUsername("Abcde");
        user.setPassword("hahahah");
        return userMapper.toUserDto(user);
    }


}
