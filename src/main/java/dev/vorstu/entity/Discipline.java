    package dev.vorstu.entity;

    import lombok.Getter;
    import lombok.Setter;

    import javax.persistence.*;
    import java.util.List;

    @Entity
    @Table(name = "discipline")
    @Getter
    @Setter
    public class Discipline {
        public Discipline() {}

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;

        @Column(name = "name")
        protected String name;

        @Column(name = "category")
        private String category;

        @Column(name = "description")
        private String description;


        @OneToMany(mappedBy = "discipline", cascade = CascadeType.ALL)
        private List<People> peopleList;

        public Discipline(String name, String category, String description) {
            this.name = name;
            this.category = category;
            this.description = description;
        }
    }