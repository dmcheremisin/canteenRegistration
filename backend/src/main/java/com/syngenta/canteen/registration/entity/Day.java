package com.syngenta.canteen.registration.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "days")
public class Day {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private LocalDate date;

    @ManyToOne
    private Week week;

    @OneToMany(mappedBy = "day", cascade = CascadeType.ALL)
    private List<Slot> slots;


}
