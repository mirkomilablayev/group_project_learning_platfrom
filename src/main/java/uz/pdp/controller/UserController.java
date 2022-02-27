package uz.pdp.controller;
/*
 Group number name is B7
 Mentor is Abror Ergashev
 B7 is the best of the best
*/

//Author --  Ablayev Mirkomil 2/19/2022 --3:24 PM 

import org.apache.catalina.session.StandardSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.UsesSunMisc;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import uz.pdp.dto.CourseDto;
import uz.pdp.model.Course;
import uz.pdp.model.User;
import uz.pdp.service.CourseService;
import uz.pdp.service.StudentService;
import uz.pdp.service.UserService;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpSession;
import javax.xml.bind.DatatypeConverter;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserService userService;


    @Autowired
    CourseService courseService;

    @Autowired
    StudentService studentService;

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
        model.addAttribute("user", user);
        userService.saver(user);
        return "login";
    }


    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model) {
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login_(@RequestParam String email,
                         @RequestParam String password,
                         Model model) {


        boolean b = userService.isexistUser(email, password);
        if (b) {
            return "login";
        }

        User currentUser = userService.getCurrentUser(password, email);
        if (currentUser.getRole().equalsIgnoreCase("Mentor")) {
            List<CourseDto> allCourses = courseService.getAllCourses(currentUser.getId());
            for (CourseDto allCours : allCourses) {
                try {
                    String pictureByteArrayString = getPictureByteArrayString(allCours.getCourse().getImg_path(), allCours.getCourse().getImg_name());
                    allCours.setImg(pictureByteArrayString);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            model.addAttribute("courses", allCourses);
            model.addAttribute("mentor", currentUser);
            return "mentor_pagel_1";
        } else if (currentUser.getRole().equalsIgnoreCase("Student")) {

            List<CourseDto> allCourse = userService.getAllCourse();
            model.addAttribute("all", allCourse);
            model.addAttribute("student", currentUser);
            return "student_page_1";
        } else if (currentUser.getRole().equalsIgnoreCase("Admin")) {
            model.addAttribute("student", currentUser);
            return "AdminPage";
        } else {
            return "login";
        }
    }

    private String getPictureByteArrayString(String path, String filename) throws IOException {
        BufferedImage image = ImageIO.read(new File(path + "/" + filename));

        ByteArrayOutputStream base = new ByteArrayOutputStream();
        ImageIO.write(image, "png", base);
        base.flush();
        byte[] imageInByteArray = base.toByteArray();
        base.close();

        String b64 = DatatypeConverter.printBase64Binary(imageInByteArray);

        return b64;
    }


    @RequestMapping(value = "/addBalance/{user_id}", method = RequestMethod.GET)
    public String addBalance(@PathVariable int user_id, Model model) {
        model.addAttribute("user_id",user_id);
        return "addBalanceForm";
    }


    @RequestMapping(value = "/addBalance/{user_id}",method = RequestMethod.POST)
    public String addBalancePost(@PathVariable int user_id,Model model,@RequestParam String balance){

        if(balance.length() == 0)
            return "addBalanceForm";

        double v = Double.parseDouble(balance);
        if (v<0)
            return "addBalanceForm";

        User userById = userService.getUserById(user_id);
        userById.setBalance(userById.getBalance()+v);
        userService.saver(userById);
        return "redirect:/profileSettigs/"+user_id;
    }

    @RequestMapping(value = "/enterSystemWithOtherRole/{user_id}",method = RequestMethod.GET)
    public String changeRole(@PathVariable int user_id,Model model){

        User userById = userService.getUserById(user_id);

        if (userById.getRole().equalsIgnoreCase("Mentor")){
            userById.setRole("Student");
            userService.saver(userById);
            List<CourseDto> allCourse = userService.getAllCourse();
            model.addAttribute("all", allCourse);
            model.addAttribute("student", userById);
            return "student_page_1";
        }else if(userById.getRole().equalsIgnoreCase("Student")){
            userById.setRole("Mentor");
            userService.saver(userById);
            List<CourseDto> allCourses = courseService.getAllCourses(userById.getId());
            for (CourseDto allCours : allCourses) {
                try {
                    String pictureByteArrayString = getPictureByteArrayString(allCours.getCourse().getImg_path(), allCours.getCourse().getImg_name());
                    allCours.setImg(pictureByteArrayString);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            model.addAttribute("courses", allCourses);
            model.addAttribute("mentor", userById);
            return "mentor_pagel_1";
        }
        return "";
    }


    @RequestMapping(value = "/editProfile/{currentUser_id}",method = RequestMethod.GET)
    public String editProfileGet(@PathVariable int currentUser_id,
                                 Model model
                                 ){


        User userById = userService.getUserById(currentUser_id);
        model.addAttribute("user_id",userById);
        return "editProfilePost";
    }


    @RequestMapping(value = "/editProfile/{currentUser_id}",method = RequestMethod.POST)
    public String editProfileGet(@PathVariable int currentUser_id,
                                 @RequestParam String firstname,
                                 @RequestParam String lastname,
                                 @RequestParam String username,
                                 @RequestParam String email,
                                 @RequestParam String bio
    ){

        User userById1 = userService.getUserById(currentUser_id);
        userById1.setFirstName(firstname);
        userById1.setLastName(lastname);
        userById1.setUsername(username);
        userById1.setEmail(email);
        userById1.setBio(bio);

        userService.saver(userById1);

        return "redirect:/profileSettigs/"+currentUser_id;
    }






}
