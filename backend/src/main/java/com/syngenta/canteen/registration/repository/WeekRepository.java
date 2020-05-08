package com.syngenta.canteen.registration.repository;

import com.syngenta.canteen.registration.entity.Week;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface WeekRepository extends JpaRepository<Week, Integer> {

    Optional<Week> findByStartLessThanEqualAndEndGreaterThanEqual(LocalDate date1, LocalDate date2);

    List<Week> findFirst6ByEndGreaterThanEqual(LocalDate date);
}
