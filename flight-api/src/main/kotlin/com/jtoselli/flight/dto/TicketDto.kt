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
                     val arrivalTime: LocalTime) {
    companion object {
        fun build(itineraryId: Int? = null,
                  departureDate: LocalDate = LocalDate.now(),
                  arrivalDate: LocalDate = LocalDate.now(),
                  originCity: String = "origin city",
                  destinationCity: String = "destination city",
                  passengerName: String = "passenger name",
                  passengerAge: Int = 30,
                  hasLuggage: Boolean = false,
                  price: BigDecimal = BigDecimal.TEN,
                  departureTime: LocalTime = LocalTime.now(),
                  arrivalTime: LocalTime = LocalTime.now()) = TicketDto(itineraryId, departureDate, arrivalDate,
                originCity, destinationCity, passengerName, passengerAge, hasLuggage, price, departureTime, arrivalTime)
    }
}