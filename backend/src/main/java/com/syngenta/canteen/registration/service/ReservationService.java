package com.syngenta.canteen.registration.service;

import com.syngenta.canteen.registration.dto.ReserveSlotDto;
import com.syngenta.canteen.registration.entity.Day;
import com.syngenta.canteen.registration.entity.Slot;
import com.syngenta.canteen.registration.entity.SlotTemplate;
import com.syngenta.canteen.registration.exception.EntityNotFoundException;
import com.syngenta.canteen.registration.exception.SlotIsFullyBookedException;
import com.syngenta.canteen.registration.repository.DayRepository;
import com.syngenta.canteen.registration.repository.ReservationRepository;
import com.syngenta.canteen.registration.repository.SlotRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ReservationService {

    private final ReservationRepository reservationRepository;
    private final SlotRepository slotRepository;
    private final DayRepository dayRepository;

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public void reserveSlot(ReserveSlotDto reserveSlotDto) {
        Integer slotId = reserveSlotDto.getSlotId();
        String username = reserveSlotDto.getUsername();
        Integer menuId = reserveSlotDto.getMenuId();

        Slot slot = slotRepository.findById(slotId)
                .orElseThrow(() -> new EntityNotFoundException("Slot with '%s' is not found", slotId));

        checkSlotFreePlaces(slotId, slot);

        removePreviousDayReservation(slot, username);

        reservationRepository.addReservation(username, slotId, menuId);
    }

    private void checkSlotFreePlaces(Integer slotId, Slot slot) {
        int reserved = slot.getReserved();
        SlotTemplate template = slot.getSlotTemplate();
        if (reserved >= template.getCapacity()) {
            throw new SlotIsFullyBookedException("Slot with '%s' is fully booked", slotId);
        }
    }

    private void removePreviousDayReservation(Slot slot, String username) {
        Day day = dayRepository.findBySlotsIs(slot)
                .orElseThrow(() -> new EntityNotFoundException("Day with slot id '%s' is not found", slot.getId()));

        reservationRepository.deletePreviousSlotReservation(username, day.getSlots());
    }
}
