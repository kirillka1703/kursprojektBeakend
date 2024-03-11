package dev.vorstu.dto;

import dev.vorstu.entity.Discipline;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Data
@Getter
@Setter
public class PeopleDTO {
    private Long id;
    private String peopleName;
    private String firstName;
    private String patronymic;
    private String disciplineName;
    private Number workingTime;
}
