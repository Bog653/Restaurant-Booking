package com.example.restaurant.repository.reservationRepo;

import com.example.restaurant.entity.model.Reservation;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface ReservationRepo extends CrudRepository<Reservation, Long>  {


    @Query("SELECT SUM(r.numberPeople) FROM Reservation r WHERE r.reserveDate = :date AND r.restaurant.id = :restaurantId")
    Integer sumPeopleByDateAndRestaurant(@Param("date") LocalDate date, @Param("restaurantId") Long restaurantId);

    @Modifying
    @Query("UPDATE Reservation r SET r.numberPeople = :newPeople WHERE r.id = :id")
    int updateNumberPeopleReservationById(@Param("id") Long id, @Param("newPeople") int newNumberPeople);

    @Modifying
    @Transactional
    int deleteReservationById(Long id);

}
