package com.example.restaurant.service.reservationService;

import com.example.restaurant.entity.dto.reservation.ReservationById;
import com.example.restaurant.entity.dto.reservation.ReservationRequest;
import com.example.restaurant.entity.dto.reservation.ReservationResponse;

public interface ReservationInterface {

    ReservationResponse saveReservation(ReservationRequest reservationRequest);

    ReservationById getReservationById(Long id);

    ReservationResponse updatePeople(Long id, ReservationRequest reservationRequest);

    void deleteReservationById(Long id);

}
