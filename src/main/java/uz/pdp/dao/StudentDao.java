package uz.pdp.dao;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import uz.pdp.dto.CourseDto;
import uz.pdp.model.Course;
import uz.pdp.model.Enrollment;


import javax.imageio.ImageIO;
import javax.xml.bind.DatatypeConverter;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class StudentDao {

    @Autowired
    private SessionFactory sessionFactory;


    public List<CourseDto> getCourses() {
        Session session = sessionFactory.getCurrentSession();

        Query query = session.createQuery("from Course");

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
            int i = (Integer) 0;
            courseDto1.setCommentCount(i);


            String img_name = course1.getImg_name();
            String img_path = course1.getImg_path();

            String pictureByteArrayString;
            try {
                pictureByteArrayString = getPictureByteArrayString(img_path, img_name);
                courseDto1.setImg(pictureByteArrayString);
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
}
