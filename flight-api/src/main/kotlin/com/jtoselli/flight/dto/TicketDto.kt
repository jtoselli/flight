package com.jtoselli.flight.dto

import java.math.BigDecimal
import java.time.LocalDate
import java.time.LocalTime
import javax.validation.constraints.PositiveOrZero

data class TicketDto(val itineraryId: Int?,
                     val departureDate: LocalDate,
                     val arrivalDate: LocalDate,
                     val originCity: String,
                     val destinationCity: String,
                     val passengerName: String,
                     @field:PositiveOrZero val passengerAge: Int,
                     val hasLuggage: Boolean = false,
                     @field:PositiveOrZero val price: BigDecimal,
                     val departureTime: LocalTime,
                     val arrivalTime: LocalTime)