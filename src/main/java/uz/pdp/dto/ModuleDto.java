package uz.pdp.dto;
/*
 Group number name is B7
 Mentor is Abror Ergashev
 B7 is the best of the best
*/

//Author --  Ablayev Mirkomil 2/21/2022 --12:42 AM 


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.pdp.model.Lesson;
import uz.pdp.model.Module;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ModuleDto {
    private Module module;
    private List<Lesson>lessons;
}
