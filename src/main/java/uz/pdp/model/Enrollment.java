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
@Entity(name = "users_courses")
public class Enrollment {
    @Id
    @GeneratedValue
    private Integer id;
    private LocalDateTime purchase_date=LocalDateTime.now();
    private boolean is_like=false;
    @ManyToOne
    private Course course;
    @ManyToOne
    private User user;


}
