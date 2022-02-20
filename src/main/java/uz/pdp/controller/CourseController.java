package uz.pdp.controller;
/*
 Group number name is B7
 Mentor is Abror Ergashev
 B7 is the best of the best
*/

//Author --  Ablayev Mirkomil 2/20/2022 --9:16 AM 


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import uz.pdp.service.CourseService;

@Controller
public class CourseController {

    @Autowired
    CourseService courseService;


    @RequestMapping(value = "/addCourse",method = RequestMethod.GET)
    public String addCourse(){
        return "";
    }

}
