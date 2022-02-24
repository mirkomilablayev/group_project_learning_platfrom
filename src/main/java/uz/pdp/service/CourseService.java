package uz.pdp.service;
/*
 Group number name is B7
 Mentor is Abror Ergashev
 B7 is the best of the best
*/

//Author --  Ablayev Mirkomil 2/20/2022 --9:17 AM 


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uz.pdp.dao.CourseDao;
import uz.pdp.dto.CourseDto;
import uz.pdp.dto.ModuleDto;
import uz.pdp.dto.TaskDto;
import uz.pdp.model.*;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    CourseDao courseDao;

    @Transactional
    public List<Category> getAllCategory(){return  courseDao.getAll();}

    @Transactional
    public void saveCourse(Course course){courseDao.saveCourse(course);}

    @Transactional
    public User getCurrentUser(int id){return courseDao.getCurrentUser(id);}

    @Transactional
    public List<CourseDto>getAllCourses(int id){return courseDao.getCourses(id);}

    @Transactional
    public void deleteCourse(int Course_id){courseDao.deleteCourse(Course_id);}

    @Transactional
    public CourseDto getCourseById(int id){return courseDao.getOneCourse(id);}

    @Transactional
    public void saveModule(Module module){courseDao.saveModule(module);}

    @Transactional
    public Course getCourse(int id){return courseDao.getCourse(id);}

    @Transactional
    public void deleteModule(int id){courseDao.deleteModule(id);}

    @Transactional
    public ModuleDto getModule(int module_id){return courseDao.getModul(module_id);}

    @Transactional
    public void saveLesson(Lesson lesson){courseDao.saveLesson(lesson);}

    @Transactional
    public Lesson getLessonById(int id){return courseDao.getLessonById(id);}

    @Transactional
    public void saveTaskAndAnswers(Task task,Option A,Option B,Option C,Option D){courseDao.saveTaskWithAnswer(task, A, B, C, D);}

    @Transactional
    public List<TaskDto> getTaskDtoList(int lesson_id){return courseDao.getLessonTasks(lesson_id);}


    @Transactional
    public void sendRequest(Request request,Course course){courseDao.sendRequest(request,course);}
}
