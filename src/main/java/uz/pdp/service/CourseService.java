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
import uz.pdp.model.Category;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    CourseDao courseDao;

    @Transactional
    public List<Category> getAllCategory(){return  courseDao.getAll();}



}
