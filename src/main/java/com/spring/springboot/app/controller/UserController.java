package com.spring.springboot.app.controller;

import com.spring.springboot.app.entity.User;
import com.spring.springboot.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String firstPage(ModelMap model) {
        model.addAttribute("user", new User());
        model.addAttribute("userList", userService.getUserList());
        return "index";
    }

    @GetMapping("/addUser")
    public String addUser(Model model) {
        model.addAttribute("user", new User());
        return "user-info";
    }

    @GetMapping("/saveUser")
    public String saveUser(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/";
    }

    @GetMapping("/updateUser")
    public String updateUser(@RequestParam("userId") long id, Model model) {
        model.addAttribute(userService.getUserById(id));
        return "user-info";
    }

    @GetMapping("/deleteUser")
    public String deleteUSer(@RequestParam("userId") long id) {
        userService.deleteUser(userService.getUserById(id));
        return "redirect:/";
    }

    @GetMapping("/error")
    public String errorViewResolver(){
        return "error";
    }
}
