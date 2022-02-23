package uz.pdp.dto;



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
