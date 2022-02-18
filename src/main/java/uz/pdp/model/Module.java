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
@Entity(name = "modules")
public class Module {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String description;
    @OneToOne
    private Course course;
    @OneToOne
    private User user;


}
