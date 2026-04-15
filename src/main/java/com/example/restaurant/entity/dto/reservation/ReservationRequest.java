package com.example.restaurant.entity.dto.reservation;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReservationRequest {

    @NotBlank
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate reserveDate;

    @NotBlank
    @JsonFormat(pattern = "HH:mm")
    private LocalTime reserveAt;

    @Positive
    private int numberPeople;

    @Positive
    @NotNull
    private Long userId;

    @Positive
    @NotNull
    private Long restaurantId;

}
