package com.syngenta.canteen.registration.service;

import com.syngenta.canteen.registration.dto.WeekDto;
import com.syngenta.canteen.registration.entity.Week;
import com.syngenta.canteen.registration.exception.EntityNotFoundException;
import com.syngenta.canteen.registration.mapper.WeekMapper;
import com.syngenta.canteen.registration.repository.WeekRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class WeekService {

    private final WeekRepository weekRepository;
    private final WeekMapper weekMapper;

    @Transactional
    public WeekDto getCurrentWeek() {
        LocalDate date = getDateForSearch();
        Week week = weekRepository.findByStartLessThanEqualAndEndGreaterThanEqual(date, date)
                .orElseThrow(() -> new EntityNotFoundException("Week with date '%s' is not found", date));
        return weekMapper.toWeekDto(week);
    }

    @Transactional
    public List<WeekDto> getNavigationWeeks() {
        LocalDate date = getDateForSearch();
        return weekRepository.findFirst6ByEndGreaterThanEqual(date).stream()
                .map(weekMapper::toWeekWithoutDays)
                .collect(Collectors.toList());
    }

    private LocalDate getDateForSearch() {
        LocalDate now = LocalDate.now();
        if (now.getDayOfWeek().equals(DayOfWeek.FRIDAY))
            return now;
        return now.with(TemporalAdjusters.next(DayOfWeek.FRIDAY));
    }

    public List<WeekDto> findAll() {
        return weekRepository.findAll().stream()
                .map(weekMapper::toWeekDto)
                .collect(Collectors.toList());
    }

    public WeekDto findById(Integer id) {
        return weekRepository.findById(id)
                .map(weekMapper::toWeekDto)
                .orElseThrow(() -> new EntityNotFoundException("Week with id '%s' is not found", id));
    }
}
