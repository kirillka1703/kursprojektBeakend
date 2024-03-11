package dev.vorstu.dto;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;
@Getter
@Setter
@NoArgsConstructor
public class EventDTO {

    private Long id;
    private String data;
    private String peopleName;
    private String disciplineName;
    private String description;

}