package com.syngenta.canteen.registration.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Formula;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "reservations")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String username;

    @Formula("(SELECT m.name FROM menu m WHERE m.id = menu_id)")
    private String menu;

    @ManyToOne
    private Slot slot;

}
