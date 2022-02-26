package uz.pdp.controller;
/*
 Group number name is B7
 Mentor is Abror Ergashev
 B7 is the best of the best
*/

//Author --  Ablayev Mirkomil 2/24/2022 --10:35 AM 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import uz.pdp.model.Course;
import uz.pdp.model.Request;
import uz.pdp.model.User;
import uz.pdp.service.AdminService;
import uz.pdp.service.CourseService;
import uz.pdp.service.UserService;

import java.util.List;

@Controller
public class AdminController {

    @Autowired
    AdminService adminService;


    @Autowired
    CourseService courseService;

    @RequestMapping(value = "/requests/{admin_id}",method = RequestMethod.GET)
    public String getRequests(Model model, @PathVariable int admin_id) {

        List<Request> requests = adminService.getallRequest();
        model.addAttribute("request", requests);
        model.addAttribute("admin_id", admin_id);
        return "requests";
    }


    @RequestMapping(value = "/backToAdminMenu/{admin_id}")
    public String back(Model model, @PathVariable int admin_id) {
        User currentUser = courseService.getCurrentUser(admin_id);
        model.addAttribute("student", currentUser);
        return "AdminPage";
    }


    @RequestMapping(value = "/accept/{admin_id}/{course_id}",method = RequestMethod.GET)
    public String acceptCourse(@PathVariable int admin_id,
                               @PathVariable int course_id,
                               Model model){


        Course course = courseService.getCourse(course_id);
        course.setInProgres(false);
        course.setIsAccepted(true);
        adminService.acceptCourse(course);

        List<Request> requests = adminService.getallRequest();
        model.addAttribute("request", requests);
        model.addAttribute("admin_id", admin_id);
        return "redirect:/requests/"+admin_id;
    }



    @RequestMapping(value = "/cancel/{admin_id}/{course_id}",method = RequestMethod.GET)
    public String canselRequest(@PathVariable int admin_id,@PathVariable int course_id){



        return "";
    }
}
