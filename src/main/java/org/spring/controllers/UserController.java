package org.spring.controllers;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.spring.dto.UserDto;
import org.spring.entity.User;
import org.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public String getAllUser(Model model){
        List<User> users = userService.getAllUsers();
        model.addAttribute("users",users);
        return "users";
    }

    @GetMapping("/registerForm")
    public String registerForm(Model model){
        UserDto userDto = new UserDto();
        model.addAttribute("userDto",userDto);
        return "register-form";
    }

    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("userDto") UserDto userDto, BindingResult result){
        if(result.hasErrors()){
            return "register-form";
        }
        User user = new User();
        user.setName(userDto.getUserName());
        user.setEmail(userDto.getEmail());
        if(userDto.getPassword().equals(userDto.getRePassword())){
            user.setPassword(userDto.getPassword());
        }
        userService.saveUser(user);
        return "redirect:/user/login";
    }
@GetMapping("/login")
    public String loginForm(Model model){
        UserDto userDto = new UserDto();
        model.addAttribute("userDto",userDto);
        return "login";
    }

    @PostMapping("/login")
    public String login(@Valid @RequestParam String email,
                        @RequestParam String password,
                        BindingResult result,
                        HttpSession session
                       ){

        if(result.hasErrors()){
            return "login";
        }
        User user = userService.loginUser(email,password);
        UserDto userDto = new UserDto();
        userDto.setUserName(user.getName());
        userDto.setEmail(user.getEmail());
        userDto.setPassword(user.getPassword());
        userDto.setRePassword(user.getPassword());

        if(userDto != null){
            session.setAttribute("userDto",userDto);
            return "profile";
        }
//        return "redirect:/user/profile";
        return "redirect:/user/login";
    }
    @GetMapping("/profile")
    public String profile(Model model){
        UserDto userDto = new UserDto();
        model.addAttribute("userDto",userDto);
        return "profile";
    }

    @GetMapping("/logout")
    public String logout(Model model, HttpSession session){
        session.invalidate();
        return "home";
    }
}
