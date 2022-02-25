package uz.pdp.dao;
/*
 Group number name is B7
 Mentor is Abror Ergashev
 B7 is the best of the best
*/

//Author --  Ablayev Mirkomil 2/24/2022 --10:36 AM 

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import uz.pdp.model.Course;
import uz.pdp.model.Module;
import uz.pdp.model.Request;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AdminDao {

    @Autowired
    SessionFactory sessionFactory;


    public List<Request> getAllRequest(){

        Session session = sessionFactory.getCurrentSession();

        Query query = session.createQuery("from requests where isAccepted = false ");
        List list = query.list();
        List<Request> requests = (List<Request>) list;

        return requests;
    }


    public void acceptCourse(Course course){
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(course);

        NativeQuery nativeQuery = currentSession.createNativeQuery("delete  from requests where course_id = " + course.getId() + ";");
        nativeQuery.executeUpdate();

    }


}
