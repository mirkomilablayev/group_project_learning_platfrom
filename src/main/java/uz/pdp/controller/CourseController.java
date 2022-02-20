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
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import uz.pdp.model.Category;
import uz.pdp.service.CourseService;

import javax.imageio.ImageIO;
import javax.xml.bind.DatatypeConverter;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.List;

@Controller
public class CourseController {

    @Autowired
    CourseService courseService;


    @RequestMapping(value = "/addCourse/{user_id}", method = RequestMethod.GET)
    public String addCourse(@PathVariable int user_id, Model model) {

        List<Category> allCategory = courseService.getAllCategory();

        model.addAttribute("categories", allCategory);
        model.addAttribute("user_id", user_id);
        model.addAttribute("checking", 1);
        return "addCourseForm";
    }


    @RequestMapping(value = "/addCourse/{user_id}", method = RequestMethod.POST)
    public String addCourse(@PathVariable int user_id,
                            @RequestParam String category,
                            @RequestParam String description,
                            @RequestParam String price,
                            @RequestParam String courseName,
                            Model model) {

        model.addAttribute("checking", 2);
        return "test";
    }


    @RequestMapping(value="/savefile",method= RequestMethod.POST,consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public String upload(@RequestParam(name = "file") CommonsMultipartFile file, Model model) throws IOException {

        String path= "D:\\crud\\Learning_platform_app\\src\\main\\resources";
        String filename=file.getOriginalFilename();

        System.out.println(path+" "+filename);

        try{
            byte barr[]=file.getBytes();

            BufferedOutputStream bout=new BufferedOutputStream(
                    new FileOutputStream(path+"/"+filename));
            bout.write(barr);
            bout.flush();
            bout.close();

        } catch (Exception e){}


        BufferedImage image =  ImageIO.read(new File(path + "/" + filename));

        ByteArrayOutputStream base = new ByteArrayOutputStream();
        ImageIO.write(image,"png",base);
        base.flush();
        byte[] imageInByteArray = base.toByteArray();
        base.close();

        String b64 = DatatypeConverter.printBase64Binary(imageInByteArray);

        model.addAttribute("base64", b64);

        return "image";
    }

}
