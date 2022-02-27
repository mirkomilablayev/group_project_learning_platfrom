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
import uz.pdp.dto.ModuleDto;
import uz.pdp.dto.TaskDto;
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
            courseDto.add(courseDto1);
        }
        return courseDto;
    }


    public void deleteCourse(int course_id) {
        Session session = sessionFactory.getCurrentSession();

        Query query = session.createQuery("select id from modules where course = " + course_id + "");
        List list = query.list();
        List<Integer> module_id = (List<Integer>) list;

        List<Integer> lesson_id = new ArrayList<>();
        for (Integer integer : module_id) {
            List<Integer>integerList = new ArrayList<>();
            Query query1 = session.createQuery("select id from lessons where module = " + integer + "");
            List list1 = query1.list();
            integerList = (List<Integer>) list1;
            lesson_id.addAll(integerList);
        }

        List<Integer>task_id = new ArrayList<>();
        for (Integer integer : lesson_id) {
            List<Integer>list2 = new ArrayList<>();
        Query query1 = session.createQuery("select id from Task where lesson = " + integer + "");
        List list1 = query1.list();
       list2= (List<Integer>) list1;
       task_id.addAll(list2);
        }


        for (Integer integer : task_id) {
            NativeQuery nativeQuery3 = session.createNativeQuery("delete from option where task_id ="+integer+";");
            nativeQuery3.executeUpdate();
        }


        for (Integer integer : lesson_id) {
            NativeQuery nativeQuery3 = session.createNativeQuery("delete from task where lesson_id = "+integer+"");
            nativeQuery3.executeUpdate();
        }

        for (Integer integer : module_id) {
                       NativeQuery nativeQuery3 = session.createNativeQuery("delete from lessons where module_id = " + integer + "");
            nativeQuery3.executeUpdate();
        }

        NativeQuery nativeQuery = session.createNativeQuery("delete from comments where course_id = " + course_id + "");
        nativeQuery.executeUpdate();

        NativeQuery nativeQuery1 = session.createNativeQuery("delete from users_courses where course_id = " + course_id + "");
        nativeQuery1.executeUpdate();

        NativeQuery nativeQuery2 = session.createNativeQuery("delete from modules where course_id = " + course_id + "");
        nativeQuery2.executeUpdate();

        NativeQuery nativeQuery3 = session.createNativeQuery("delete from courses where id = " + course_id + "");
        nativeQuery3.executeUpdate();
    }

    public CourseDto getOneCourse(int course_id) {
        CourseDto courseDto = new CourseDto();

        Session session = sessionFactory.getCurrentSession();

        Query query = session.createQuery("from Course  where id = " + course_id + "");
        Object o = query.uniqueResult();
        Course course = (Course) o;
        courseDto.setCourse(course);


        Query query1 = session.createQuery("from comments where course = " + course_id + "");
        List list = query.list();
        List<Comment> allComment = (List<Comment>) list;
        courseDto.setComments(allComment);

        Query query2 = session.createQuery("from modules where course = " + course_id + "");
        List list1 = query2.list();
        List<Module> getModules = (List<Module>) list1;
        courseDto.setModules(getModules);

        Query query3 = session.createQuery("from users_courses where course = " + course_id + "");
        List list2 = query3.list();
        List<Enrollment> getStudents = (List<Enrollment>) list2;
        courseDto.setUsers(getStudents);

        try {
            String img = getPictureByteArrayString(course.getImg_path(), course.getImg_name());
            courseDto.setImg(img);
        } catch (IOException e) {
            e.printStackTrace();
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


    public void saveModule(Module module) {
        Session session = sessionFactory.getCurrentSession();
        session.save(module);
    }


    public Course getCourse(int course_id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Course  where id = " + course_id + "");
        Object o = query.uniqueResult();
        Course course = (Course) o;
        return course;
    }


    public void deleteModule(int module_id) {
        Session currentSession = sessionFactory.getCurrentSession();

        Query query = currentSession.createQuery("select id from lessons where module =" + module_id + "");
        List list = query.list();
        List<Integer>lesson_id = (List<Integer>)list;

        List<Integer>task_id = new ArrayList<>();
        for (Integer integer : lesson_id) {
            List<Integer>tasks_id = new ArrayList<>();
          tasks_id = (List<Integer>) currentSession.createQuery("select id from Task where lesson = "+integer+"").list();
          task_id.addAll(tasks_id);
        }

        for (Integer integer : task_id) {
            NativeQuery nativeQuery = currentSession.createNativeQuery("delete from option where task_id = " + integer + ";");
            nativeQuery.executeUpdate();

        }

        for (Integer integer : lesson_id) {
            NativeQuery nativeQuery = currentSession.createNativeQuery("delete from task where lesson_id = "+integer+";");
            nativeQuery.executeUpdate();
        }



        NativeQuery nativeQuery = currentSession.createNativeQuery("delete from lessons where module_id = " + module_id + ";");
        nativeQuery.executeUpdate();

        NativeQuery nativeQuery1 = currentSession.createNativeQuery("delete from modules where id = " + module_id + "");
        nativeQuery1.executeUpdate();
    }


    public ModuleDto getModul(int module_id) {

        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from modules where id = " + module_id + "");
        Object o = query.uniqueResult();
        Module module = (Module) o;


        Query query1 = session.createQuery("from lessons where module = " + module_id + "");
        List list = query1.list();
        List<Lesson> lessons = (List<Lesson>) list;
        for (Lesson lesson : lessons) {
            Object o1 = session.createQuery("select count(*) from Task where lesson = " + lesson.getId() + "").uniqueResult();
            Long count = (Long) o1;
            lesson.setTaskCount(count);
        }

        ModuleDto moduleDto = new ModuleDto();
        moduleDto.setModule(module);
        moduleDto.setLessons(lessons);

        return moduleDto;
    }


    public void saveLesson(Lesson lesson) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.save(lesson);
    }


    public Lesson getLessonById(int id) {
        Session currentSession = sessionFactory.getCurrentSession();

        Query query = currentSession.createQuery("from lessons  where  id = " + id + "");
        Object o = query.uniqueResult();
        Lesson lesson = (Lesson) o;

        return lesson;
    }

    public void saveTaskWithAnswer(Task task, Option A, Option B, Option C, Option D) {

        Session currentSession = sessionFactory.getCurrentSession();

        currentSession.save(task);
        currentSession.save(A);
        currentSession.save(B);
        currentSession.save(C);
        currentSession.save(D);

    }

    public List<TaskDto> getLessonTasks(int lesson_id) {
        Session currentSession = sessionFactory.getCurrentSession();

        Query query = currentSession.createQuery("from Task where lesson = " + lesson_id + "");
        List list1 = query.list();
        List<Task> tasks = (List<Task>) list1;

        List<TaskDto> taskDtos = new ArrayList<>();
        for (Task task : tasks) {
            TaskDto taskDto = new TaskDto();
            Query query1 = currentSession.createQuery("from Option where task = " + task.getId() + "");
            List list = query1.list();
            List<Option> answers = (List<Option>) list;

            taskDto.setTask(task);
            taskDto.setOption(answers);
            taskDtos.add(taskDto);
        }
        return taskDtos;
    }



    public void sendRequest(Request request,Course course){
        Session session = sessionFactory.getCurrentSession();
        session.save(request);
        session.saveOrUpdate(course);
    }


    public void cancelRequest(Course course){
        Session currentSession = sessionFactory.getCurrentSession();
        NativeQuery nativeQuery = currentSession.createNativeQuery("delete from requests where course_id = " + course.getId() + ";");
        nativeQuery.executeUpdate();
        course.setInProgres(false);
        currentSession.saveOrUpdate(course);
    }

    public List<Comment> getAllComments(int Course_id){
        Session currentSession = sessionFactory.getCurrentSession();
        return (List<Comment>) currentSession.createQuery("from comments where course = " + Course_id + "").list();
    }

    public void saveMessage(Comment comment){
        sessionFactory.getCurrentSession().saveOrUpdate(comment);
    }

}
