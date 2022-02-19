package uz.pdp.model;

//import static uz.sardor.Main.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

//Sardor {18.02.2022}{ 15:40}
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "answers")
public class Answer {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(nullable = false)
    private String answer;


    @ManyToOne
    private Task task;
}
