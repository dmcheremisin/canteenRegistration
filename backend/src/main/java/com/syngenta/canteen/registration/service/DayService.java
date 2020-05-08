package com.syngenta.canteen.registration.service;

import com.syngenta.canteen.registration.dto.DayDto;
import com.syngenta.canteen.registration.exception.EntityNotFoundException;
import com.syngenta.canteen.registration.mapper.DayMapper;
import com.syngenta.canteen.registration.repository.DayRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class DayService {

    private final DayRepository dayRepository;
    private final DayMapper dayMapper;

    @Transactional
    public DayDto findById(Integer id) {
        return dayRepository.findById(id)
                .map(dayMapper::toDayDto)
                .orElseThrow(() -> new EntityNotFoundException("Day with id '%s' is not found", id));
    }
}
