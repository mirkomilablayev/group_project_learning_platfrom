package uz.pdp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.dao.StudentDao;
import uz.pdp.dto.CourseDto;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentDao studentDao;

    public List<CourseDto> getAllCourses(){
        return studentDao.getCourses();
    }

}
