package dev.vorstu.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class StatisticDTO {
    private Long id;
    private String peopleName;
    private String quantity;
    private String mainevent;
    private String allevent;
}
