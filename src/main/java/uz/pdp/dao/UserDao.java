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
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import uz.pdp.dto.CourseDto;
import uz.pdp.model.Course;
import uz.pdp.model.Enrollment;
import uz.pdp.model.User;

import javax.imageio.ImageIO;
import javax.xml.bind.DatatypeConverter;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//Author --  Ablayev Mirkomil 2/19/2022 --3:25 PM
@Repository
public class UserDao {

    @Autowired
    SessionFactory sessionFactory;



    public List<CourseDto> getCourses() {
        Session session = sessionFactory.getCurrentSession();

        Query query = session.createQuery("from Course  where isAccepted = true");

        List list = query.list();
        List<Course> courseList = (List<Course>) list;
        int likes = 0;
        int dislikes = 0;
        List<CourseDto> courseDto = new ArrayList<>();


        for (Course course1 : courseList) {
            CourseDto courseDto1 = new CourseDto();
            Query query1 = session.createQuery("from users_courses where course = " + course1.getId() + "");
            List list1 = query1.list();
            List<Enrollment> userCourses = (List<Enrollment>) list1;
            courseDto1.setCourse(course1);
            courseDto1.setUsers(userCourses);
            for (Enrollment userCours : userCourses) {
                if (userCours.is_like() == true) {
                    likes++;
                }
            }
            courseDto1.setLikeCount(likes);

            Query query2 = session.createQuery("select count(*) from comments  where course = " + course1.getId() + "");
            Object o = query2.uniqueResult();
            int i = (Integer) 0;
            courseDto1.setCommentCount(i);
            try {
                String img = getPictureByteArrayString(course1.getImg_path(), course1.getImg_name());
                courseDto1.setImg(img);
            } catch (IOException e) {
                e.printStackTrace();
            }

            courseDto.add(courseDto1);
        }
        return courseDto;
    }

    private String getPictureByteArrayString(String path, String filename) throws IOException {
        BufferedImage image = ImageIO.read(new File(path + "/" + filename));
        ByteArrayOutputStream base = new ByteArrayOutputStream();
        ImageIO.write(image, "png", base);
        base.flush();
        byte[] imageInByteArray = base.toByteArray();
        base.close();
        String b64 = DatatypeConverter.printBase64Binary(imageInByteArray);
        return b64;
    }


    public boolean isExist(String username){
        Session session = sessionFactory.getCurrentSession();
        boolean b = (Long) session.createQuery("select count(*) from User where username = '" + username + "'").uniqueResult() > 0;
        return b;
    }




    public void saver(User user){
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.save(user);
    }

    public boolean isExist1(String email,String password){
        Session currentSession = sessionFactory.getCurrentSession();
        boolean b = (Long)currentSession.createQuery("select count(*) from User where password = '"+password+"' and email = '"+email+"'").uniqueResult()==0;
        return b;
    }


    public User getCurrentUser(String password,String email){
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from User where email = '" + email + "' and password = '"+password+"'");
        Object o = query.uniqueResult();
        User user = (User)o;
        return user;
    }

}
