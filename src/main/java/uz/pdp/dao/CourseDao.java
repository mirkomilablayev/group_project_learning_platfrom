package uz.pdp.dao;
/*
 Group number name is B7
 Mentor is Abror Ergashev
 B7 is the best of the best
*/

//Author --  Ablayev Mirkomil 2/20/2022 --9:16 AM 

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import uz.pdp.dto.CourseDto;
import uz.pdp.model.*;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CourseDao {

    @Autowired
    private SessionFactory sessionFactory;


    public List<Category> getAll() {
        Session session = sessionFactory.getCurrentSession();
        Query from_categories_ = session.createQuery("from categories ");
        List list = from_categories_.list();
        List<Category> category = (List<Category>) list;
        return category;
    }

    public void saveCourse(Course course) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.save(course);
    }


    public User getCurrentUser(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from User where id = " + id + "");
        Object o = query.uniqueResult();
        User user = (User) o;
        return user;
    }


    public List<CourseDto> getCourses(int user_id) {
        Session session = sessionFactory.getCurrentSession();

        Query query = session.createQuery("from Course  where owner = " + user_id + "");

        List list = query.list();
        List<Course> courseList = (List<Course>) list;
        int likes = 0;
        int dislikes = 0;
        List<CourseDto> courseDto = new ArrayList<>();


        for (Course course1 : courseList) {
            CourseDto courseDto1 = new CourseDto();
            Query query1 = session.createQuery("from users_courses where course = " + course1.getId() + "");
            List list1 = query1.list();
            List<UserCourse> userCourses = (List<UserCourse>) list1;
            courseDto1.setCourse(course1);
            courseDto1.setUsers(userCourses);
            for (UserCourse userCours : userCourses) {
                if (userCours.is_like() == true) {
                    likes++;
                }
            }
            courseDto1.setLikeCount(likes);

            Query query2 = session.createQuery("select count(*) from comments  where course = " + course1.getId() + "");
            Object o = query2.uniqueResult();
            int i = (Integer) 0;
            courseDto1.setCommentCount(i);
            courseDto.add(courseDto1);
        }
        return courseDto;
    }


    public void deleteCourse(int course_id) {
        Session session = sessionFactory.getCurrentSession();

        NativeQuery nativeQuery = session.createNativeQuery("delete from comments where course_id = " + course_id + ";");
        nativeQuery.executeUpdate();

        NativeQuery nativeQuery1 = session.createNativeQuery("delete from users_courses where course_id = " + course_id + ";");
        nativeQuery1.executeUpdate();

        Query query = session.createQuery("select id from modules where course = " + course_id + "");
        List list = query.list();
        List<Integer> module_id = (List<Integer>) list;

        NativeQuery nativeQuery2 = session.createNativeQuery("delete from modules where course_id = " + course_id + ";");
        nativeQuery2.executeUpdate();

        for (Integer integer : module_id) {
            NativeQuery nativeQuery3 = session.createNativeQuery("delete from lessons where module_id = " + integer + ";");
            nativeQuery3.executeUpdate();
        }

        NativeQuery nativeQuery3 = session.createNativeQuery("delete from courses where id = " + course_id + ";");
        nativeQuery3.executeUpdate();
    }


}
