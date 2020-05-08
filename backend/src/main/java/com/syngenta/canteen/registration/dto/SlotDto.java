package com.syngenta.canteen.registration.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SlotDto {

    private Integer id;
    private SlotTemplateDto slotTemplate;
    private int reserved;
    private List<ReservationDto> reservations;

}
