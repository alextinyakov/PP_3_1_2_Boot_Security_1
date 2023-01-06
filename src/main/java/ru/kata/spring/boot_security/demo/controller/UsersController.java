package ru.kata.spring.boot_security.demo.controller;


import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.kata.spring.boot_security.demo.models.User;

@Controller
@RequestMapping("/")
public class UsersController {

    @GetMapping("/users_page")
    public String usersPage() {

        return "users_page";
    }

    @GetMapping("/user_info")
    public String showUserInfo(Model model) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("user", user);
        return "user_info";
    }
}
