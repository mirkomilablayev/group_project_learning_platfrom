package uz.pdp.dao;
/*
 Group number name is B7
 Mentor is Abror Ergashev
 B7 is the best of the best
*/

//Author --  Ablayev Mirkomil 2/20/2022 --9:16 AM 

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import uz.pdp.model.Category;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CourseDao {

    @Autowired
    private SessionFactory sessionFactory;


    public List<Category> getAll(){

        Session session = sessionFactory.getCurrentSession();

        Query from_categories_ = session.createQuery("from categories ");
        List list = from_categories_.list();

        List<Category> category  = (List<Category>) list;
        return category;
    }

}
