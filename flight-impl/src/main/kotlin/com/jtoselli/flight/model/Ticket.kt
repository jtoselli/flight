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

}
