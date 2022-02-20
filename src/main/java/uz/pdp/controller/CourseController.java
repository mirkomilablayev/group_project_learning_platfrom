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
import uz.pdp.model.Category;
import uz.pdp.service.CourseService;

import javax.imageio.ImageIO;
import javax.xml.bind.DatatypeConverter;
import java.awt.image.BufferedImage;
import java.io.*;
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
        model.addAttribute("checking", 1);
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



        String imageUrl = getImageUrl(file,imgPath);


        String imageName = getImageName(file);

        try {
            String picture = getPicture(imgPath, imageName);

            model.addAttribute("picture",picture);

            return "image";
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "image";
    }

    public String getImageName(CommonsMultipartFile image){
        String fileName = image.getOriginalFilename();
        return fileName;
    }


    public String getImageUrl(CommonsMultipartFile image,String path) {
        String filename = image.getOriginalFilename();
        System.out.println(path + " " + filename);
        try {
            String imgUrl = path+"/"+filename;
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


    private String getPicture(String path, String filename) throws IOException {
        BufferedImage image =  ImageIO.read(new File(path + "/" + filename));

        ByteArrayOutputStream base = new ByteArrayOutputStream();
        ImageIO.write(image,"png",base);
        base.flush();
        byte[] imageInByteArray = base.toByteArray();
        base.close();

        String b64 = DatatypeConverter.printBase64Binary(imageInByteArray);

       return b64;
    }




}
