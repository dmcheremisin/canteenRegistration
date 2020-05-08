package com.syngenta.canteen.registration.mapper;

import com.syngenta.canteen.registration.dto.DayDto;
import com.syngenta.canteen.registration.entity.Day;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

@Mapper(componentModel = "spring")
public interface DayMapper {

    @Mapping(source = "date", target = "name", qualifiedByName = "dateToDayName")
    DayDto toDayDto(Day day);

    @Named("dateToDayName")
    static String dateToDayName(LocalDate date) {
        return date.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.ENGLISH);
    }
}