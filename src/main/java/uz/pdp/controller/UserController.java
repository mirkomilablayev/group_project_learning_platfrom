package uz.pdp.controller;
/*
 Group number name is B7
 Mentor is Abror Ergashev
 B7 is the best of the best
*/

//Author --  Ablayev Mirkomil 2/19/2022 --3:24 PM 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import uz.pdp.model.User;
import uz.pdp.service.UserService;

import java.time.LocalDateTime;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/start", method = RequestMethod.GET)
    public String start(Model model) {
        return "MainMenu";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String registerPanel() {
        return "register_page1";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerLogic(@RequestParam String firstname,
                                @RequestParam String lastname,
                                @RequestParam String username,
                                @RequestParam String balance,
                                @RequestParam String password,
                                @RequestParam String who,
                                @RequestParam String bio,
                                @RequestParam String email,
                                Model model) {

        if (firstname.length() == 0)
            return "register_page1";

        if (username.length() == 0)
            return "register_page1";

        boolean exist = userService.isExist(username);
        if (exist)
            return "register_page1";

        if (password.length() == 0)
            return "register_page1";

        if (email.length() == 0)
            return "register_page1";

        User user = new User();
        user.setFirstName(firstname);
        user.setLastName(lastname);

        user.setUsername(username);
        user.setPassword(password);
        user.setBio(bio);
        user.setEmail(email);
        if (balance.length() > 0)
            user.setBalance(Double.parseDouble(balance));
        user.setRegister_at(LocalDateTime.now());
        user.setRole(who);
        model.addAttribute("user",user);
        userService.saver(user);
        return "login";
    }

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(Model model){
        User user = new User();
        model.addAttribute("user",user);
        return "login";
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login_(@RequestParam String email,
                         @RequestParam String password,
                         Model model){

        boolean b = userService.isexistUser(email, password);
        if (b){
            User user = new User();
            model.addAttribute("user",user);
            return "login";
        }

        User currentUser = userService.getCurrentUser(password, email);

            if (currentUser.getRole().equalsIgnoreCase("Mentor")){
                model.addAttribute("mentor",currentUser);
                return "mentor_pagel_1";
            }else if(currentUser.getRole().equalsIgnoreCase("Student")){
                model.addAttribute("student",currentUser);
                return "student_page_1";
            }else{
                return "login";
            }
    }


}
