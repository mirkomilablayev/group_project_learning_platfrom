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
import uz.pdp.model.Course;
import uz.pdp.model.User;

import java.util.List;

//Author --  Ablayev Mirkomil 2/19/2022 --3:25 PM
@Service
public class UserService {


    @Autowired
    UserDao userDao;


    @Transactional
    public List<Course> getAllCourse(){
        return userDao.getAllCourse();
    }

    @Transactional
    public boolean isExist(String username){return userDao.isExist(username);}

    @Transactional
    public void saver(User user){userDao.saver(user);}
}
