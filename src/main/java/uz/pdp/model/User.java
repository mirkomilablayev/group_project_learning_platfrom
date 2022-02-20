package uz.pdp.model;
/*
 Group number name is B7
 Mentor is Abror Ergashev
 B7 is the best of the best
*/

//Author --  Ablayev Mirkomil 2/18/2022 --11:44 AM 

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false ,unique = true)
    private String username;

    private String bio;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false ,unique = true)
    private String email;

    private Double balance;

    private LocalDateTime register_at = LocalDateTime.now();

     private String role;

    private String imgPath;
}
