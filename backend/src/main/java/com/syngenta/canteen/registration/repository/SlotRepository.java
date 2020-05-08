package com.syngenta.canteen.registration.repository;

import com.syngenta.canteen.registration.entity.Slot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SlotRepository extends JpaRepository<Slot, Integer> {
}
