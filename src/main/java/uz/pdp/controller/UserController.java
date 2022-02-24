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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import uz.pdp.dto.CourseDto;
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
                         Model model,
                         HttpSession session) {

//        HttpSession session =
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

            final List<CourseDto> allCourses = studentService.getAllCourses();
            model.addAttribute("courses", allCourses);
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
}
