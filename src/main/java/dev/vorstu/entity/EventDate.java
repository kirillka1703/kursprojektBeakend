package dev.vorstu.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;

@Entity
@Table(name = "EventDate")
@NoArgsConstructor
@Getter
@Setter
public class EventDate {

    public EventDate(String date) {
        this.eventDate = date;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "eventDate")
    protected String eventDate;
}