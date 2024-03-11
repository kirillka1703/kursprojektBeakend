package dev.vorstu;

import dev.vorstu.entity.*;


import dev.vorstu.repositories.*;
import dev.vorstu.entity.EventDate;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import dev.vorstu.repositories.StatisticRepository;

import java.util.Arrays;


@Getter
@Setter
@Component
public class Initializer {
    @Autowired
    private DisciplineRepository disciplineRepository;
    @Autowired
    private PeopleRepository peopleRepository;
    @Autowired
    private EventRepository eventRepository;
    @Autowired
    private StatisticRepository statisticRepository;
    @Autowired
    private EventDateRepository EventDateRepository;
    public void initial() {



        Discipline discipline1 = new Discipline("Баскетбол", "Командный", "Игра, в к-рой мяч забрасывают руками в подвешенную сетку (называемую корзиной) противной партии.");
        Discipline discipline2 = new Discipline("Волейбол", "Командный", "Спортивная игра в мяч, перебрасываемый руками через сетку от одной команды к другой.");
        Discipline discipline3 = new Discipline("Настольный теннис", "Личный", "Олимпийский вид спорта, спортивная игра с мячом, в которой используют специальные ракетки и игровой стол, разграниченный сеткой пополам.");

        People people1 = new People(1L,"Игнат", "Илья", "ДМИТРИЧ", discipline1, 75L);
        People people2 = new People(2L,"Серебрянский", "Дмитрий", "Николаевич", discipline2, 9775L);
        People people3 = new People(3L,"Певторак", "Викторина", "Юрьевдень", discipline2, 1775L);
        People people4 = new People(4L,"Кораблина", "Анастюша", "Михайловна", discipline3, 775L);

        Statistic statistic1 = new Statistic( people1 ,"","Баскетбол","Баскетбол");
        Statistic statistic2 = new Statistic( people2 ,"","Волейбол","Волейбол");
        Statistic statistic3 = new Statistic( people3 ,"","Волейбол","Волейбол");
        Statistic statistic4 = new Statistic( people4 ,"","Настольный теннис","Настольный теннис");


        EventDate[] dates = {
                new EventDate("1 января"), new EventDate("2 января"), new EventDate("3 января"), new EventDate("4 января"),
                new EventDate("5 января"), new EventDate("6 января"), new EventDate("7 января"), new EventDate("8 января"),
                new EventDate("9 января"), new EventDate("10 января"), new EventDate("11 января"), new EventDate("12 января"),
                new EventDate("13 января"), new EventDate("14 января"), new EventDate("15 января"), new EventDate("16 января"),
                new EventDate("17 января"), new EventDate("18 января"), new EventDate("19 января"), new EventDate("20 января"),
                new EventDate("21 января"), new EventDate("22 января"), new EventDate("23 января"), new EventDate("24 января"),
                new EventDate("25 января"), new EventDate("26 января"), new EventDate("27 января"), new EventDate("28 января"),
                new EventDate("29 января"), new EventDate("30 января"), new EventDate("31 января")
        };

        EventDateRepository.saveAll(Arrays.asList(dates));


        people1.setDiscipline(discipline1);
        people2.setDiscipline(discipline2);
        people3.setDiscipline(discipline2);
        people4.setDiscipline(discipline3);


        disciplineRepository.save(discipline1);
        disciplineRepository.save(discipline2);
        disciplineRepository.save(discipline3);


        peopleRepository.save(people1);
        peopleRepository.save(people2);
        peopleRepository.save(people3);
        peopleRepository.save(people4);

        statisticRepository.save(statistic1);
        statisticRepository.save(statistic2);
        statisticRepository.save(statistic3);
        statisticRepository.save(statistic4);




    }
}