package com.example.restaurant.service.reservationService;

import com.example.restaurant.entity.model.Reservation;
import com.example.restaurant.entity.model.Restaurant;
import com.example.restaurant.entity.model.User;
import com.example.restaurant.entity.dto.reservation.ReservationById;
import com.example.restaurant.entity.dto.reservation.ReservationRequest;
import com.example.restaurant.entity.dto.reservation.ReservationResponse;
import com.example.restaurant.entity.dto.restaurantDto.RestaurantDto;
import com.example.restaurant.entity.dto.userDto.UserDto;
import com.example.restaurant.repository.reservationRepo.ReservationRepo;
import com.example.restaurant.repository.restaurantRepo.RestaurantRepository;
import com.example.restaurant.repository.userRepo.UserRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.NoSuchElementException;

@Service
public class ReservationService implements ReservationInterface{

    @Autowired
    private ReservationRepo reservationRepo;

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    // Probably used less code if you use EntityGraph...

    // In this service we need peopleCapacity of Restaurant and other reservation by date and
    // calculate if there is availability capacity

    @Override
    public ReservationResponse saveReservation(ReservationRequest reservation) {
        Reservation reservationSave;
        ReservationResponse reservationResponse;
        // Take Restaurant capacity by id
        Restaurant restaurant = restaurantRepository.findById(reservation.getRestaurantId())
                .orElseThrow(()-> new NoSuchElementException("Restaurant not found "));

        User user = userRepository.findById(reservation.getUserId())
                .orElseThrow(() -> new NoSuchElementException("User not found"));

         int restaurantCapacity = restaurant.getPeopleCapacity();

        // Take total number of reservation for the date
        Integer numberReservation = reservationRepo.sumPeopleByDateAndRestaurant(reservation.getReserveDate(), restaurant.getId());
        int currentOccupied = (numberReservation != null) ? numberReservation : 0;

        if(restaurantCapacity - (currentOccupied + reservation.getNumberPeople()) > 0){
           // mapper
            reservationSave = modelMapper.map(reservation, Reservation.class);
            reservationSave.setUser(user);
            reservationSave.setRestaurant(restaurant);
            reservationResponse = modelMapper.map(reservationRepo.save(reservationSave),ReservationResponse.class);
            reservationResponse.setUserId(reservationSave.getUser().getId());
            reservationResponse.setRestaurantId(reservationSave.getRestaurant().getId());
            return reservationResponse;
        }else{
             throw new NoSuchElementException("Restaurant is full capacity");
        }

    }

    @Override
    public ReservationById getReservationById(Long id) {
        ReservationById reservationResponse;
        Reservation reservation = reservationRepo.findById(id)
                .orElseThrow(()-> new NoSuchElementException("Reservation not found"));

        UserDto userDto = modelMapper.map(reservation.getUser(), UserDto.class);
        RestaurantDto restaurantDto = modelMapper.map(reservation.getRestaurant(),RestaurantDto.class);
        reservationResponse = modelMapper.map(reservation,ReservationById.class);
        reservationResponse.setUserDto(userDto);
        reservationResponse.setRestaurantDto(restaurantDto);

        return reservationResponse;

    }

    @Override
    @Transactional
    public ReservationResponse updatePeople(Long id, ReservationRequest reservationRequest) {
        ReservationResponse response;
        ReservationById reservation = getReservationById(id);
        Restaurant restaurant = restaurantRepository.findById(reservationRequest.getRestaurantId())
                .orElseThrow(()-> new NoSuchElementException("Restaurant not found "));

        int restaurantCapacity = restaurant.getPeopleCapacity();
        Integer numberReservation = reservationRepo.sumPeopleByDateAndRestaurant(reservation.getReserveDate(), restaurant.getId());
        int currentOccupied = (numberReservation != null) ? numberReservation : 0;

        // capacity is equal to: currentOccupied <--( there is present the sum of oldest number of people)
        // I need to remove this oldest value and add the newest value present in reservationRequest.
        int capacity = restaurantCapacity - (currentOccupied - reservation.getNumberPeople() + reservationRequest.getNumberPeople());
        if(capacity <= 0) throw new NoSuchElementException("Restaurant is full capacity");

        int raw = reservationRepo.updateNumberPeopleReservationById(id, reservationRequest.getNumberPeople());

        if(raw == 0 ) throw new NoSuchElementException("Reservation is not modify ");
           response = modelMapper.map(reservationRequest, ReservationResponse.class);
           response.setId(id);
           return response;

        }

    @Override
    @Transactional
    public void deleteReservationById(Long id) {

       int raw = reservationRepo.deleteReservationById(id);

       if (raw == 0) throw new NoSuchElementException("Bad request to delete reservation");

    }
}
