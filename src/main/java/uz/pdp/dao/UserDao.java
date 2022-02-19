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
import uz.pdp.model.User;

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


    public boolean isExist(String username){
        Session session = sessionFactory.getCurrentSession();
        boolean b = (Long) session.createQuery("select count(*) from User where username = '" + username + "'").uniqueResult() > 0;
        return b;
    }

//    public boolean isExist(String number){
//        Session session = sessionFactory.getCurrentSession();
//        boolean exists = (Long) session.createQuery("select count(*) from User where phoneNumber = '"+number+"'").uniqueResult() > 0;
//        return exists;
//    }

    public void saver(User user){
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.save(user.getRole());
        currentSession.save(user);
    }


}
