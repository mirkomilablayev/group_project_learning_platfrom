package uz.pdp.dto;
/*
 Group number name is B7
 Mentor is Abror Ergashev
 B7 is the best of the best
*/

//Author --  Ablayev Mirkomil 2/20/2022 --2:24 PM 

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.pdp.model.Comment;
import uz.pdp.model.Course;
import uz.pdp.model.Module;
import uz.pdp.model.UserCourse;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CourseDto {
    private Course course;
    private List<UserCourse>users;
    private List<Comment>comments;
    private List<Module>modules;
    private String img;
    private int likeCount;
    private int commentCount;
}
