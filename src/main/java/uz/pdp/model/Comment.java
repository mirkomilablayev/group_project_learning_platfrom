package uz.pdp.model;

//import static uz.sardor.Main.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

//Sardor {18.02.2022}{ 15:40}
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "comments")
public class Comment {
    @Id
    @GeneratedValue
    private Integer id;
    private String title;
    @ManyToOne
    private Course course;
    @ManyToOne
    private User user;


}
