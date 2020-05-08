package com.syngenta.canteen.registration.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "weeks")
public class Week {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private LocalDate start;
    private LocalDate end;

    @OneToMany(mappedBy = "week", cascade = CascadeType.ALL)
    private List<Day> days;

}
