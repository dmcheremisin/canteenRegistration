package com.syngenta.canteen.registration.repository;

import com.syngenta.canteen.registration.entity.Reservation;
import com.syngenta.canteen.registration.entity.Slot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {

    @Modifying(clearAutomatically = true)
    @Query(value = "INSERT INTO reservations (username, slot_id, menu_id) VALUES (:username, :slotId, :menuId)", nativeQuery = true)
    void addReservation(@Param("username") String username,
                        @Param("slotId") Integer slotId,
                        @Param("menuId") Integer menuId);


    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Query("delete from Reservation r where r.slot in :slots and r.username = :username")
    void deletePreviousSlotReservation(@Param("username") String username, @Param("slots") List<Slot> slots);
}
