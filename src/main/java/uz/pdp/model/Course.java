package uz.pdp.model;

//import static uz.sardor.Main.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

//Sardor {18.02.2022}{ 15:40}
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "courses")
public class Course {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String description;
    private double price;
    private LocalDateTime uploaded_at=LocalDateTime.now();
    private String img_path;

    @ManyToOne
    private Category category;

}
