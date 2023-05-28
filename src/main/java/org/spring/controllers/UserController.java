package org.spring.controllers;
import org.spring.entity.User;
import org.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public String getAllUser(Model model){
        List<User> users = userService.getAllUsers();
        model.addAttribute("users",users);
        return "users";
    }

}
