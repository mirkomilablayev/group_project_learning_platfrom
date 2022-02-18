package uz.pdp.model;

//import static uz.sardor.Main.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

//Sardor {18.02.2022}{ 15:45}
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "tasks")
public class Task {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(nullable = false)
    private String question;

    @ManyToOne
    private Lesson lesson;

}
