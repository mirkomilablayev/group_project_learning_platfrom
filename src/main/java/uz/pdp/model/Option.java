package uz.pdp.model;
/*
 Group number name is B7
 Mentor is Abror Ergashev
 B7 is the best of the best
*/

//Author --  Ablayev Mirkomil 2/23/2022 --11:53 AM 

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Option {

    @Id
    @GeneratedValue
    private Integer id;

    private String answer;

    private Boolean isCorrect;

    @ManyToOne
    private Task task;
}
