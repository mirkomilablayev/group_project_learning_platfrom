package uz.pdp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import uz.pdp.dto.CourseDto;
import uz.pdp.model.User;
import uz.pdp.service.StudentService;

import javax.jws.WebParam;
import java.util.List;

@Controller
public class StudentController {





    @Autowired
    StudentService studentService;




    @RequestMapping(value = "/searchCourses/{currentUser_id}",method = RequestMethod.GET)
    public String search(@PathVariable int currentUser_id, Model model, @RequestParam String search){

        List<CourseDto> courseBySearch = studentService.getCourseBySearch(search);
        User currentUser = studentService.getCurrentUser(currentUser_id);
        model.addAttribute("all",courseBySearch);
        model.addAttribute("student", currentUser);
        return "student_page_1";
    }

    @RequestMapping(value = "/buyNow/{course_id}/{user_id}",method = RequestMethod.GET)
    public String buyNow(@PathVariable int course_id,
                         @PathVariable int user_id,
                         Model model){

        studentService.buyCourse(user_id,course_id);
        List<CourseDto> courseBySearch = studentService.getCourseBySearch();
        User currentUser = studentService.getCurrentUser(user_id);
        model.addAttribute("all",courseBySearch);
        model.addAttribute("student", currentUser);
        return "student_page_1";

    }


    @RequestMapping(value = "/myCourses/{user_id}",method = RequestMethod.GET)
    public String myCourses(@PathVariable int user_id,Model model){

        List<CourseDto> courseDtos = studentService.myCourse(user_id);

        model.addAttribute("user_id",user_id);
        model.addAttribute("courses",courseDtos);
        return "myCourses";
    }





}
