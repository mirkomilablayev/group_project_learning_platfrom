package uz.pdp.service;
/*
 Group number name is B7
 Mentor is Abror Ergashev
 B7 is the best of the best
*/

//Author --  Ablayev Mirkomil 2/24/2022 --10:37 AM 


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uz.pdp.dao.AdminDao;
import uz.pdp.model.Course;
import uz.pdp.model.Request;

import java.util.List;

@Service
@Transactional
public class AdminService {

    @Autowired
    AdminDao adminDao;

    public List<Request>getallRequest(){
        return adminDao.getAllRequest();
    }

    public void acceptCourse(Course course){adminDao.acceptCourse(course);}

}
