package dev.vorstu.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Table(name = "Event")
@Getter
@Setter
@NoArgsConstructor
public class Event {

    public Event (String date, Discipline discipline, People people, String description) {
        this.date = date;
        this.peopleName = people.getPeopleName();
        this.disciplineName = discipline.getName();
        this.description = description;
    }
    public Event(Long id, String date, People people, Discipline discipline, String description) {
        this(date, discipline, people, description);
        this.id = id;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "date")
    private String date;

    @Column(name = "discipline")
    private String disciplineName;

    @Column(name = "peopleName")
    private String peopleName;

    @Column(name = "description")
    private String description;


}