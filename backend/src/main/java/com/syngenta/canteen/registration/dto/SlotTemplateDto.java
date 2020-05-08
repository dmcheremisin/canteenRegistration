package com.syngenta.canteen.registration.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;

@Getter
@Setter
public class SlotTemplateDto {

    private Integer id;

    private LocalTime start;
    private LocalTime end;

    private Integer capacity;

}
