package com.syngenta.canteen.registration.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class DayDto {

    private Integer id;
    private String name;
    @JsonFormat(pattern = "YYYY-MM-dd")
    private LocalDate date;
    private List<SlotDto> slots;

}
