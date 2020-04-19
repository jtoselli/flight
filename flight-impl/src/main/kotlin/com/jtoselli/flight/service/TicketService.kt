package com.jtoselli.flight.service

import com.jtoselli.flight.dto.TicketDto
import com.jtoselli.flight.model.Ticket
import com.jtoselli.flight.model.repository.TicketRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import javax.inject.Inject

// service interface
interface TicketService {
    fun findById(itineraryId: Int): TicketDto
    fun save(ticketDto: TicketDto): TicketDto
}

// extension functions
internal fun TicketDto.toTicket() = Ticket(itineraryId, departureDate, arrivalDate, originCity, destinationCity, passengerName,
        passengerAge, hasLuggage, price, departureTime, arrivalTime)
internal fun Ticket.toTicketDto() = TicketDto(id, departureDate, arrivalDate, originCity, destinationCity, passengerName,
        passengerAge, hasLuggage, price, departureTime, arrivalTime)

// default implementation of TicketService
@Service
internal class DefaultTicketService @Inject constructor(
        private val ticketRepository: TicketRepository) : TicketService {
    @Transactional(readOnly = true)
    override fun findById(itineraryId: Int) = ticketRepository
            .findById(itineraryId).map {it.toTicketDto()}.orElseThrow(::TicketNotFoundException)!!

    @Transactional
    override fun save(ticketDto: TicketDto)=  ticketRepository
            .save(ticketDto.toTicket()).toTicketDto()
}