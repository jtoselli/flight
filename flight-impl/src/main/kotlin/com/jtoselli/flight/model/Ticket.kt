package com.jtoselli.flight.model

import java.math.BigDecimal
import java.time.LocalDate
import java.time.LocalTime
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Ticket(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Int? = null,
        val departureDate: LocalDate,
        val arrivalDate: LocalDate,
        val originCity: String,
        val destinationCity: String,
        val passengerName: String,
        val passengerAge: Int,
        val hasLuggage: Boolean,
        val price: BigDecimal,
        val departureTime: LocalTime,
        val arrivalTime: LocalTime) {

    companion object {
        fun build(id: Int? = null,
                  departureDate: LocalDate = LocalDate.now(),
                  arrivalDate: LocalDate = LocalDate.now(),
                  originCity: String = "Origin City",
                  destinationCity: String = "Destination City",
                  passengerName: String = "Passenger Name",
                  passengerAge: Int = 30,
                  hasLuggage: Boolean = false,
                  price: BigDecimal = BigDecimal.TEN,
                  departureTime: LocalTime = LocalTime.now(),
                  arrivalTime: LocalTime = LocalTime.now()) = Ticket(id, departureDate, arrivalDate, originCity,
                destinationCity, passengerName, passengerAge, hasLuggage, price, departureTime, arrivalTime)
    }
}
