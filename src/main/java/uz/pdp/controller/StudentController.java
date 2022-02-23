package uz.pdp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import uz.pdp.service.StudentService;

@Controller
public class StudentController {

    private final String imgPath = "C:\\Users\\user\\Desktop\\HomeWork\\my_group_project\\src\\main\\resources";
//    private final String imgPath = "D:\\crud\\Learning_platform_app\\src\\main\\resources";

    @Autowired
    StudentService studentService;

//    @RequestMapping(value = "/",method = RequestMethod.GET)
//    public

    // some codes .....

}
