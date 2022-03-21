package com.teletearbies.roskildedaycare.controller;

import com.teletearbies.roskildedaycare.entity.User;
import com.teletearbies.roskildedaycare.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class UserController {

   @Autowired
    UserService userService;
    @RequestMapping("/userList")
    public String listAllUsers(Model model) {
        List<User> listUsers = userService.getAllUsers();
        model.addAttribute("listUsers", listUsers);
        return "users";
    }



}
