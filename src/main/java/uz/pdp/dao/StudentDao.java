package uz.pdp.dao;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import uz.pdp.dto.CourseDto;
import uz.pdp.model.*;


import javax.imageio.ImageIO;
import javax.xml.bind.DatatypeConverter;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentDao {

    @Autowired
    SessionFactory sessionFactory;


    public List<CourseDto> getCourses(String search) {

        Session session = sessionFactory.getCurrentSession();

        Query query = session.createQuery("from Course  where isAccepted = true and name like '%" + search + "%'");

        List list = query.list();
        List<Course> courseList = (List<Course>) list;
        int likes = 0;
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
            Long i = (Long) o;
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

    public List<CourseDto> getCourses() {

        Session session = sessionFactory.getCurrentSession();

        Query query = session.createQuery("from Course  where isAccepted = true");

        List list = query.list();
        List<Course> courseList = (List<Course>) list;
        int likes = 0;
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
            Long i = (Long) o;
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


    public User getCurrentUser(int id) {
        return sessionFactory.getCurrentSession().get(User.class, id);
    }


    public void buyCourse(int course_id, int user_id) {
        Session session = sessionFactory.getCurrentSession();

        User user = session.get(User.class, user_id);
        Course course = session.get(Course.class, course_id);
        int owner = course.getOwner();
        User user1 = session.get(User.class, owner);

        if (user.getBalance() >= course.getPrice()) {
            double price = course.getPrice();

            user.setBalance(user.getBalance() - price);
            user1.setBalance(user1.getBalance() + price);

            boolean b = (Long) session.createQuery("select count(*) from users_courses where course=" + course_id + " and user=" + user_id + "").uniqueResult() == 0;
            if (b) {
                NativeQuery nativeQuery = session.createNativeQuery("insert into users_courses(is_like, purchase_date, course_id, user_id)\n" +
                        "VALUES(false,now()," + course_id + "," + user_id + ");");
                nativeQuery.executeUpdate();
            }
        }
    }


    public List<CourseDto> myCourse(int student_id) {
        Session session = sessionFactory.getCurrentSession();

        Query query3 = session.createQuery("select course.id from users_courses where user = " + student_id + "");
        List list2 = query3.list();
        List<Integer> user_course_id = (List<Integer>) list2;

        List<Course> courseList = new ArrayList<>();
        for (Integer integer : user_course_id) {
            List<Course> courses = new ArrayList<>();
            Query query = session.createQuery("from Course where isAccepted = true and id=" + integer + "");
            List list = query.list();
            courses = (List<Course>) list;
            courseList.addAll(courses);
        }

        int likes = 0;
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
            Long i = (Long) o;
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


    public void likeDislike(int id) {

        Session session = sessionFactory.getCurrentSession();
        Enrollment enrollment = session.get(Enrollment.class, id);

        if (enrollment.is_like()) {
            enrollment.set_like(false);
        } else {
            enrollment.set_like(true);
        }
        session.saveOrUpdate(enrollment);

    }

    public List<Module> module(int course_id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from modules where course=" + course_id + "");
        List<Module> modules = (List<Module>) query.list();
        return modules;
    }

    public List<Lesson>allLesson(int module_id){
        return (List<Lesson>)sessionFactory.getCurrentSession().createQuery("from lessons where module="+module_id+"").list();
    }


}
