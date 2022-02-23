package uz.pdp.dto;
/*
 Group number name is B7
 Mentor is Abror Ergashev
 B7 is the best of the best
*/

//Author --  Ablayev Mirkomil 2/23/2022 --8:27 PM 

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.pdp.model.Option;
import uz.pdp.model.Task;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TaskDto {
    private Task task;
    private List<Option> option;
}
