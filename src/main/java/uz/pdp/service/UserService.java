package uz.pdp.service;
/*
 Group number name is B7
 Mentor is Abror Ergashev
 B7 is the best of the best
*/

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uz.pdp.dao.UserDao;
import uz.pdp.dto.CourseDto;
import uz.pdp.model.Course;
import uz.pdp.model.User;

import java.util.List;

//Author --  Ablayev Mirkomil 2/19/2022 --3:25 PM
@Service
@Transactional
public class UserService {


    @Autowired
    UserDao userDao;


    public List<CourseDto> getAllCourse(){
        return userDao.getCourses();
    }

    public boolean isExist(String username){return userDao.isExist(username);}

    public void saver(User user){userDao.saver(user);}

    public boolean isexistUser(String email,String password){return userDao.isExist1(email,password);}

    public User getCurrentUser(String password,String email){return userDao.getCurrentUser(password, email);}

    public User getUserById(int id){return userDao.getCurrentUserById(id);}
}
