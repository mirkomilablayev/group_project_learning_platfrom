package uz.pdp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import uz.pdp.dto.CourseDto;
import uz.pdp.dto.TaskDto;
import uz.pdp.model.Lesson;
import uz.pdp.model.Module;
import uz.pdp.model.Option;
import uz.pdp.model.User;
import uz.pdp.service.StudentService;

import javax.jws.WebParam;
import java.util.ArrayList;
import java.util.List;

@Controller
public class StudentController {


    @Autowired
    StudentService studentService;


    @RequestMapping(value = "/searchCourses/{currentUser_id}", method = RequestMethod.POST)
    public String search(@PathVariable int currentUser_id, Model model, @RequestParam String search) {

        List<CourseDto> courseBySearch = studentService.getCourseBySearch(search);
        User currentUser = studentService.getCurrentUser(currentUser_id);
        model.addAttribute("all", courseBySearch);
        model.addAttribute("student", currentUser);
        return "student_page_1";
    }

    @RequestMapping(value = "/buyNow/{course_id}/{user_id}", method = RequestMethod.GET)
    public String buyNow(@PathVariable int course_id,
                         @PathVariable int user_id,
                         Model model) {

        studentService.buyCourse(user_id, course_id);
        List<CourseDto> courseBySearch = studentService.getCourseBySearch();
        User currentUser = studentService.getCurrentUser(user_id);
        model.addAttribute("all", courseBySearch);
        model.addAttribute("student", currentUser);
        return "student_page_1";

    }


    @RequestMapping(value = "/myCourses/{user_id}", method = RequestMethod.GET)
    public String myCourses(@PathVariable int user_id, Model model) {


        List<CourseDto> courseDtos = studentService.myCourse(user_id);
        model.addAttribute("user_id", user_id);
        model.addAttribute("courses", courseDtos);
        return "myCourses";
    }


    @RequestMapping(value = "/likecourse/{user_id}/{u_c_id}", method = RequestMethod.GET)
    public String likeDislike(@PathVariable int user_id,
                              @PathVariable int u_c_id) {
        studentService.likeDislike(u_c_id);
        return "redirect:/myCourses/" + user_id;
    }

    @RequestMapping(value = "/backToUserPage/{user_id}", method = RequestMethod.GET)
    public String back(@PathVariable int user_id, Model model) {

        User currentUser = studentService.getCurrentUser(user_id);
        List<CourseDto> allCourse = studentService.getCourseBySearch();
        model.addAttribute("all", allCourse);
        model.addAttribute("student", currentUser);
        return "student_page_1";
    }

    @RequestMapping(value = "/profileSettigs/{user_id}", method = RequestMethod.GET)
    public String ShowUserProfile(@PathVariable int user_id,
                                  Model model) {

        User currentUser = studentService.getCurrentUser(user_id);
        model.addAttribute("currentUser",currentUser);
        return "UserProfile";
    }


    @RequestMapping(value = "/startLearning/{user_id}/{course_id}",method = RequestMethod.GET)
    public String startLearning(@PathVariable int user_id,
                                @PathVariable int course_id,
                                Model model){

        List<Module> modules = studentService.getModules(course_id);
        model.addAttribute("module",modules);
        model.addAttribute("user_id",user_id);
        return "StudentCourseModule";
    }

    @RequestMapping(value = "/lessons/{user_id}/{module_id}",method = RequestMethod.GET)
    public String lessons_(@PathVariable int user_id,
                           @PathVariable int module_id,
                           Model model){

        List<Lesson> allLesson = studentService.getAllLesson(module_id);

        model.addAttribute("user_id",user_id);
        model.addAttribute("allLesson",allLesson);
        return "studentCourseLesson";
    }


    @RequestMapping(value = "lessons/{user_id}/{lesson_id}/{video_url}",method = RequestMethod.GET)
    public String getTasks(@PathVariable int user_id,
                           @PathVariable int lesson_id,
                           @PathVariable String video_url,
                           Model model){

        model.addAttribute("user_id",user_id);
        model.addAttribute("lesson_id",lesson_id);
        model.addAttribute("video_url",video_url);
        return "Watch_video";
    }

    @RequestMapping(value = "/startQuiz/{user_id}/{lesson_id}",method = RequestMethod.GET)
    public String getStartedTakingQuiz(@PathVariable int user_id,
                                       @PathVariable int lesson_id,
                                       Model model){
        List<TaskDto> tasks_ = studentService.getTasks_(lesson_id);
        model.addAttribute("quiz",tasks_);
        model.addAttribute("user_id",user_id);
        model.addAttribute("lesson_id",lesson_id);
        return "TakingQuiz";
    }


    @RequestMapping(value = "/checkQuiz/{user_id}/{lessoon_id}",method = RequestMethod.POST)
    public String checkQuiz(@PathVariable int user_id,
                            Model model,
                            @PathVariable int lessoon_id,
                            @RequestParam String TEST1,
                            @RequestParam String TEST2,
                            @RequestParam String TEST3
                            ){

        List<TaskDto> tasks_ = studentService.getTasks_(lessoon_id);
        List<Integer>answers = new ArrayList<>();

        int correct_ = 0;

        for (Option option : tasks_.get(0).getOption()) {
            if (option.getAnswer().equalsIgnoreCase(TEST1)) {
                if (option.getIsCorrect()) {
                    correct_=correct_+1;
                }
            }
        }

        for (Option option : tasks_.get(0).getOption()) {
            if (option.getAnswer().equalsIgnoreCase(TEST2)) {
                if (option.getIsCorrect()) {
                    correct_=correct_+1;
                }
            }
        }

        for (Option option : tasks_.get(0).getOption()) {
            if (option.getAnswer().equalsIgnoreCase(TEST3)) {
                if (option.getIsCorrect()) {
                    correct_=correct_+1;
                }
            }
        }



        model.addAttribute("correct",correct_);
        return "result";
    }


}
