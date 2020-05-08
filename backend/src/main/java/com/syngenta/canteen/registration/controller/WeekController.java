package com.syngenta.canteen.registration.controller;

import com.syngenta.canteen.registration.dto.WeekDto;
import com.syngenta.canteen.registration.service.WeekService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.syngenta.canteen.registration.util.RestConstants.WEEK_PATH;

@RestController
@RequestMapping(WEEK_PATH)
@RequiredArgsConstructor
public class WeekController {

    private final WeekService weekService;

    @GetMapping
    public List<WeekDto> getWeeks() {
        return weekService.findAll();
    }

    @GetMapping("/navigation")
    public List<WeekDto> getNavigationWeeks() {
        return weekService.getNavigationWeeks();
    }

    @GetMapping("/{id}")
    public WeekDto getWeekById(@PathVariable Integer id) {
        return weekService.findById(id);
    }
}
