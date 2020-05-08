package com.syngenta.canteen.registration.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReservationDto {

    private Integer id;
    private String username;
    private String menu;
    private String slotId;

}
