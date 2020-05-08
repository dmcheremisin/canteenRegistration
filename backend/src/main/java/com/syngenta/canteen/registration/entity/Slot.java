package com.syngenta.canteen.registration.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Formula;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "slots")
public class Slot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private SlotTemplate slotTemplate;

    @Formula("(SELECT count(*) FROM reservations r WHERE r.slot_id = id)")
    private int reserved;

    @ManyToOne
    private Day day;

    @OneToMany(mappedBy = "slot", cascade = CascadeType.ALL)
    private List<Reservation> reservations;

}
