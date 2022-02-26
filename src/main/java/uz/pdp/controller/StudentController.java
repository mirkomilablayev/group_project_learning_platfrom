package uz.pdp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import uz.pdp.dto.CourseDto;
import uz.pdp.model.Course;
import uz.pdp.service.StudentService;

import java.util.List;

@Controller
public class StudentController {


    @Autowired
    StudentService studentService;



}
