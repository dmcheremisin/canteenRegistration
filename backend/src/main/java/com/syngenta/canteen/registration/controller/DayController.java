package com.syngenta.canteen.registration.controller;

import com.syngenta.canteen.registration.dto.DayDto;
import com.syngenta.canteen.registration.service.DayService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.syngenta.canteen.registration.util.RestConstants.DAY_PATH;

@RestController
@RequestMapping(DAY_PATH)
@RequiredArgsConstructor
public class DayController {

    private final DayService dayService;

    @GetMapping("/{id}")
    public DayDto getDayById(@PathVariable Integer id) {
        return dayService.findById(id);
    }
}
