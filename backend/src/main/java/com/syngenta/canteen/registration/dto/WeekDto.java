package com.syngenta.canteen.registration.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class WeekDto {

    private Integer id;
    private String month;
    @JsonFormat(pattern = "YYYY-MM-dd")
    private LocalDate start;
    @JsonFormat(pattern = "YYYY-MM-dd")
    private LocalDate end;
    private List<DayDto> days;

}
