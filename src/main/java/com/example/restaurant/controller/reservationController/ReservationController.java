package com.example.restaurant.controller.reservationController;

import com.example.restaurant.entity.dto.reservation.ReservationById;
import com.example.restaurant.entity.dto.reservation.ReservationRequest;
import com.example.restaurant.entity.dto.reservation.ReservationResponse;
import com.example.restaurant.service.reservationService.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import javax.validation.constraints.Min;


@Controller
@RequestMapping("/app/v1")
public class ReservationController {

@Autowired
public ReservationService reservationService;


   @GetMapping(path = "/reservation/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
   @ResponseBody
   @ResponseStatus(HttpStatus.OK)
   public ReservationById findReservationById(@PathVariable @Min(1) Long id){

       return reservationService.getReservationById(id);
   }


    @PostMapping(path = "/reservation", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public ReservationResponse saveReservation(@Valid @RequestBody ReservationRequest reservation){

        return reservationService.saveReservation(reservation);
    }


    @PutMapping(value = "reservation/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public ReservationResponse updatePeopleReservation(@PathVariable @Min(1) Long id, @Valid @RequestBody ReservationRequest reservationRequest){

       return reservationService.updatePeople(id, reservationRequest);
    }


    @DeleteMapping(value = "/reservation/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> deleteReservation(@PathVariable @Min(1) Long id){


       reservationService.deleteReservationById(id);
       return ResponseEntity.noContent().build();
    }

}
