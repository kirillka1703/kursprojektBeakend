package dev.vorstu.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "people")
@Getter
@Setter
public class People {

    public People() {
    }

    public People(String peopleName, String firstName, String patronymic, Discipline discipline, Long workingTime) {
        this.peopleName = peopleName;
        this.firstName = firstName;
        this.patronymic = patronymic;
        this.disciplineName = discipline.getName();
        this.workingTime = workingTime;
    }

    public People(Long id, String peopleName, String firstName, String patronymic, Discipline discipline, Long workingTime) {
        this(peopleName, firstName, patronymic, discipline, workingTime);
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "people_id")
    private Long id;

    @Column(name = "peopleName")
    private String peopleName;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "patronymic")
    private String patronymic;

    @Column(name = "workingTime")
    private Long workingTime;

    @Column(name = "discipline")
    private String disciplineName;


    @ManyToOne
    @JoinColumn(name = "discipline_id")
    private Discipline discipline;
}