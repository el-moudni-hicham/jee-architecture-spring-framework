package ma.enset.usersrolesmanytomanycase.web;

import lombok.AllArgsConstructor;
import ma.enset.usersrolesmanytomanycase.entites.User;
import ma.enset.usersrolesmanytomanycase.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class UserController {
    private UserService userService;
    @GetMapping("/users/{username}")
    public User user(@PathVariable String username){
        User user = userService.findUserByUserName(username);
        return user;
    }
}
