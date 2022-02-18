package uz.pdp.model;
/*
 Group number name is B7
 Mentor is Abror Ergashev
 B7 is the best of the best
*/

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

//Author --  Ablayev Mirkomil 2/18/2022 --11:41 AM
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(unique = true)
    private String name;
}
