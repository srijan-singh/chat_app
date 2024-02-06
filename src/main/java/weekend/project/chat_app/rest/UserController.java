package weekend.project.chat_app.rest;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import weekend.project.chat_app.entity.Users;
import weekend.project.chat_app.service.UserService;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value="user/registration", consumes="application/json")
    public boolean registerUser(@RequestBody Users user) {
        return userService.registration(user);
    }

    @PostMapping(value = "user/login", consumes="application/json", produces = "application/json")
    public Users loginUser(@RequestBody Users user){
        System.out.println(userService.login(user.getUserID(), user.getPassword()));
        return userService.login(user.getUserID(), user.getPassword());
    }

    @GetMapping(value = "user/badpractice", produces = "application/json")
    public List<Users> showAll(){
        return userService.showAll();
    }
    

}

