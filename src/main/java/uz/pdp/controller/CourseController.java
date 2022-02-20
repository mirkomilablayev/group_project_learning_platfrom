package uz.pdp.controller;
/*
 Group number name is B7
 Mentor is Abror Ergashev
 B7 is the best of the best
*/

//Author --  Ablayev Mirkomil 2/20/2022 --9:16 AM 


import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import uz.pdp.dto.CourseDto;
import uz.pdp.dto.ModuleDto;
import uz.pdp.model.Category;
import uz.pdp.model.Course;
import uz.pdp.model.Module;
import uz.pdp.model.User;
import uz.pdp.service.CourseService;

import javax.imageio.ImageIO;
import javax.xml.bind.DatatypeConverter;
import java.awt.image.BufferedImage;
import java.io.*;
import java.time.LocalDateTime;
import java.util.List;

@Controller
public class CourseController {

    private final String imgPath = "D:\\crud\\Learning_platform_app\\src\\main\\resources";

    @Autowired
    CourseService courseService;


    @RequestMapping(value = "/addCourse/{user_id}", method = RequestMethod.GET)
    public String addCourse(@PathVariable int user_id, Model model) {
        List<Category> allCategory = courseService.getAllCategory();
        model.addAttribute("categories", allCategory);
        model.addAttribute("user_id", user_id);
        return "addCourseForm";
    }


    @RequestMapping(value = "/addCourse/{user_id}", method = RequestMethod.POST)
    public String addCourse(@PathVariable int user_id,
                            @RequestParam String category,
                            @RequestParam String description,
                            @RequestParam String price,
                            @RequestParam String courseName,
                            Model model,
                            @RequestParam("file") CommonsMultipartFile file) {


        if (courseName.length() == 0) {
            List<Category> allCategory = courseService.getAllCategory();
            model.addAttribute("categories", allCategory);
            model.addAttribute("user_id", user_id);
            return "addCourseForm";
        }

        if (price.length() == 0) {
            List<Category> allCategory = courseService.getAllCategory();
            model.addAttribute("categories", allCategory);
            model.addAttribute("user_id", user_id);
            return "addCourseForm";
        }

        Double price1 = Double.parseDouble(price);

        if (price1 <= 0) {
            List<Category> allCategory = courseService.getAllCategory();
            model.addAttribute("categories", allCategory);
            model.addAttribute("user_id", user_id);
            return "addCourseForm";
        }

        Course course = new Course();
        course.setPrice(price1);
        course.setCategory(category);
        course.setDescription(description);
        course.setName(courseName);
        course.setUploaded_at(LocalDateTime.now());
        course.setImg_name(getImageName(file));
        course.setImg_path(imgPath);
        course.setOwner(user_id);
        courseService.saver(course);
        getImageUrl(file, imgPath);


        List<CourseDto> allCourses = courseService.getAllCourses(user_id);
        for (CourseDto allCours : allCourses) {
            try {
                String pictureByteArrayString = getPictureByteArrayString(allCours.getCourse().getImg_path(), allCours.getCourse().getImg_name());
                allCours.setImg(pictureByteArrayString);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        User currentUser = courseService.getCurrentUser(user_id);
        model.addAttribute("courses", allCourses);
        model.addAttribute("mentor", currentUser);
        return "mentor_pagel_1";
    }

    public String getImageName(CommonsMultipartFile image) {
        String fileName = image.getOriginalFilename();
        return fileName;
    }


    public String getImageUrl(CommonsMultipartFile image, String path) {
        String filename = image.getOriginalFilename();
        System.out.println(path + " " + filename);
        try {
            String imgUrl = path + "/" + filename;
            byte barr[] = image.getBytes();
            BufferedOutputStream bout = new BufferedOutputStream(new FileOutputStream(imgUrl));
            bout.write(barr);
            bout.flush();
            bout.close();
            return imgUrl;
        } catch (Exception e) {
            System.out.println(e);
        }
        return "";
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


    @RequestMapping(value = "/deleteCourse/{course_id}/{user_id}", method = RequestMethod.GET)
    public String deleteCourse(@PathVariable int course_id,
                               Model model,
                               @PathVariable int user_id) {


        courseService.deleteCourse(course_id);


        List<CourseDto> allCourses = courseService.getAllCourses(user_id);
        for (CourseDto allCours : allCourses) {
            try {
                String pictureByteArrayString = getPictureByteArrayString(allCours.getCourse().getImg_path(), allCours.getCourse().getImg_name());
                allCours.setImg(pictureByteArrayString);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        User currentUser = courseService.getCurrentUser(user_id);
        model.addAttribute("courses", allCourses);
        model.addAttribute("mentor", currentUser);
        return "mentor_pagel_1";
    }

    @RequestMapping(value = "/info/{user_id}", method = RequestMethod.GET)
    public String getInfo(@PathVariable int user_id, Model model) {
        List<CourseDto> allCourses = courseService.getAllCourses(user_id);
        for (CourseDto allCours : allCourses) {
            try {
                String pictureByteArrayString = getPictureByteArrayString(allCours.getCourse().getImg_path(), allCours.getCourse().getImg_name());
                allCours.setImg(pictureByteArrayString);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        User currentUser = courseService.getCurrentUser(user_id);
        model.addAttribute("courses", allCourses);
        model.addAttribute("mentor", currentUser);
        return "mentor_pagel_1";
    }


    @RequestMapping(value = "/more/{course_id}")
    public String moreInfo(@PathVariable int course_id, Model model) {
        CourseDto course = courseService.getCourseById(course_id);
        model.addAttribute("course", course);
        return "oneCourseDefinition";
    }


    @RequestMapping(value = "/back/{user_id}", method = RequestMethod.GET)
    public String back(@PathVariable int user_id, Model model) {
        List<CourseDto> allCourses = courseService.getAllCourses(user_id);
        for (CourseDto allCours : allCourses) {
            try {
                String pictureByteArrayString = getPictureByteArrayString(allCours.getCourse().getImg_path(), allCours.getCourse().getImg_name());
                allCours.setImg(pictureByteArrayString);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        User currentUser = courseService.getCurrentUser(user_id);
        model.addAttribute("courses", allCourses);
        model.addAttribute("mentor", currentUser);
        return "mentor_pagel_1";
    }


    @RequestMapping(value = "/addModule/{user_id}/{course_id}", method = RequestMethod.GET)
    public String addModule(@PathVariable int user_id,
                            @PathVariable int course_id,
                            Model model) {

        model.addAttribute("user_id", user_id);
        model.addAttribute("course_id", course_id);
        return "addModuleForm";
    }


    @RequestMapping(value = "/addModule/{user_id}/{course_id}", method = RequestMethod.POST)
    public String addModuleLogic(@PathVariable int user_id,
                                 @PathVariable int course_id,
                                 @RequestParam String name,
                                 @RequestParam String description,
                                 Model model) {
        User currentUser = courseService.getCurrentUser(user_id);


        Module module = new Module();
        module.setName(name);
        module.setDescription(description);
        module.setUser(currentUser);
        module.setCourse(courseService.getCourse(course_id));

        courseService.saveModule(module);
        CourseDto course1 = courseService.getCourseById(course_id);
        model.addAttribute("course", course1);
        return "oneCourseDefinition";
    }


    @RequestMapping(value = "deleteModule/{module_id}/{course_id}", method = RequestMethod.GET)
    public String deleteModule(@PathVariable int module_id,
                               @PathVariable int course_id,
                               Model model) {

        courseService.deleteModule(module_id);

        CourseDto course1 = courseService.getCourseById(course_id);
        model.addAttribute("course", course1);
        return "oneCourseDefinition";
    }


    @RequestMapping(value = "/moreInfoModul/{module_id}", method = RequestMethod.GET)
    public String moduleInfo(@PathVariable int module_id,
                             Model model) {
        ModuleDto module = courseService.getModule(module_id);
        model.addAttribute("module",module);
        return "oneModulDefinition";
    }

    @RequestMapping(value = "/addLesson/{module_id}" ,method = RequestMethod.GET)
    public String addLesson(@PathVariable int module_id,Model model){

        return "addLessonForm";
    }


}
