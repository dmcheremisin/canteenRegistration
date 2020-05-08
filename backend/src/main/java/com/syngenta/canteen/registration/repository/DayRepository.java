package com.syngenta.canteen.registration.repository;

import com.syngenta.canteen.registration.entity.Day;
import com.syngenta.canteen.registration.entity.Slot;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DayRepository extends JpaRepository<Day, Integer> {

    Optional<Day> findBySlotsIs(Slot slot);
}
