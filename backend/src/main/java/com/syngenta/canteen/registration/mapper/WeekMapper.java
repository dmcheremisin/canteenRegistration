package com.syngenta.canteen.registration.mapper;

import com.syngenta.canteen.registration.dto.WeekDto;
import com.syngenta.canteen.registration.entity.Week;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

@Mapper(componentModel = "spring", uses = DayMapper.class)
public interface WeekMapper {

    @Mapping(target = "month", source = "start", qualifiedByName = "dateToMonthName")
    WeekDto toWeekDto(Week week);

    @Mapping(target = "days", ignore = true)
    @Mapping(target = "month", source = "start", qualifiedByName = "dateToMonthName")
    WeekDto toWeekWithoutDays(Week week);

    @Named("dateToMonthName")
    static String dateToMonthName(LocalDate date) {
        return date.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH);
    }
}