package uz.pdp.model;
/*
 Group number name is B7
 Mentor is Abror Ergashev
 B7 is the best of the best
*/

//Author --  Ablayev Mirkomil 2/24/2022 --7:52 AM 

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.EnableLoadTimeWeaving;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "requests")
public class Request {

    @Id
    @GeneratedValue
    private Integer id;


    @ManyToOne
    private User mentor;

    @OneToOne
    private Course course;

    private boolean isAccepted;
}
