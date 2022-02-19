package uz.pdp.dao;
/*
 Group number name is B7
 Mentor is Abror Ergashev
 B7 is the best of the best
*/

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import uz.pdp.model.Course;

import java.util.ArrayList;
import java.util.List;

//Author --  Ablayev Mirkomil 2/19/2022 --3:25 PM
@Repository
public class UserDao {

    @Autowired
    SessionFactory sessionFactory;


    public List<Course> getAllCourse() {
        Session session = sessionFactory.getCurrentSession();

        Query from_courses_ = session.createQuery("from courses ");
        List list = from_courses_.list();

        System.out.println(list);

        return list;
    }


}
