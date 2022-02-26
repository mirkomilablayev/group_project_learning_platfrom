package uz.pdp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uz.pdp.dao.StudentDao;
import uz.pdp.dto.CourseDto;
import uz.pdp.model.User;

import java.util.List;

@Service
@Transactional
public class StudentService {

    @Autowired
    StudentDao studentDao;



    public List<CourseDto> getCourseBySearch(String search){
        return studentDao.getCourses(search);
    }

    public User getCurrentUser(int id){
        return studentDao.getCurrentUser(id);
    }

}
