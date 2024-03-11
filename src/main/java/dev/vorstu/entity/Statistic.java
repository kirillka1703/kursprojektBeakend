package dev.vorstu.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "statistic")
@NoArgsConstructor
@Getter
@Setter
public class Statistic {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name ="peopleName")
    private String peopleName;

    @Column(name = "quantity")
    private String quantity;

    @Column(name = "mainevent")
    private String mainevent;

    @Column(name = "allevent")
    private String allevent;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;

    public Statistic(People people, String quantity, String mainevent, String allevent) {
        this.peopleName = people.getPeopleName();
        this.quantity = quantity;
        this.mainevent = mainevent;
        this.allevent = allevent;
    }
}