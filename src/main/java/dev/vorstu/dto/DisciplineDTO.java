package dev.vorstu.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DisciplineDTO {
    private Long id;
    protected String name;
    private String category;
    private String description;

}