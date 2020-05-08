package com.syngenta.canteen.registration.controller;

import com.syngenta.canteen.registration.dto.ReserveSlotDto;
import com.syngenta.canteen.registration.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.syngenta.canteen.registration.util.RestConstants.RESERVATION_PATH;

@RestController
@RequiredArgsConstructor
@RequestMapping(RESERVATION_PATH)
public class ReservationController {

    private final ReservationService reservationService;

    @PostMapping
    public void reserveSlot(@RequestBody ReserveSlotDto reserveSlotDto) {
        reservationService.reserveSlot(reserveSlotDto);
    }
}
