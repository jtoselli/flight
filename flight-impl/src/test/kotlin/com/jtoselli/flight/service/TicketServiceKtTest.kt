package com.jtoselli.flight.service

import com.jtoselli.flight.dto.TicketDto
import com.jtoselli.flight.model.Ticket
import com.jtoselli.flight.model.repository.TicketRepository
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.junit.jupiter.MockitoExtension
import java.util.*

internal class TicketServiceKtTest {
    @Test
    fun `test Ticket#toTicketDto function`() {
        val model = Ticket.build()

        val dto = model.toTicketDto()

        assertEquals(model.id, dto.itineraryId)
        assertEquals(model.departureDate, dto.departureDate)
        assertEquals(model.arrivalDate, dto.arrivalDate)
        assertEquals(model.originCity, dto.originCity)
        assertEquals(model.destinationCity, dto.destinationCity)
        assertEquals(model.hasLuggage, dto.hasLuggage)
        assertEquals(model.passengerAge, dto.passengerAge)
        assertEquals(model.price, dto.price)
        assertEquals(model.departureTime, dto.departureTime)
        assertEquals(model.arrivalTime, dto.arrivalTime)
    }

    @Test
    fun `test TicketDto#toTicket function`() {
        val dto = TicketDto.build()

        val model = dto.toTicket()

        assertEquals(dto.itineraryId, model.id)
        assertEquals(dto.departureDate, model.departureDate)
        assertEquals(dto.arrivalDate, model.arrivalDate)
        assertEquals(dto.originCity, model.originCity)
        assertEquals(dto.destinationCity, model.destinationCity)
        assertEquals(dto.hasLuggage, model.hasLuggage)
        assertEquals(dto.passengerAge, model.passengerAge)
        assertEquals(dto.price, model.price)
        assertEquals(dto.departureTime, model.departureTime)
        assertEquals(dto.arrivalTime, model.arrivalTime)
    }
}

@ExtendWith(MockitoExtension::class)
internal class DefaultTicketServiceTest {
    @Mock
    private lateinit var repository: TicketRepository

    @InjectMocks
    private lateinit var subject: DefaultTicketService

    @Test
    fun `test findById returns proper result`() {
        val id = 1
        val ticket = Ticket.build()
        `when`(repository.findById(id)).thenReturn(Optional.of(ticket))

        val actual = subject.findById(id)

        assertEquals(ticket.id, actual.itineraryId)
    }

    @Test
    fun `test findById throws TicketNotFoundException`() {
        val id = 1
        `when`(repository.findById(id)).thenReturn(Optional.empty())

        assertThrows<TicketNotFoundException> { subject.findById(id) }
    }

    @Test
    fun `test save calls repository and returns updated dto`() {
        val dto = TicketDto.build()
        val ticket = dto.toTicket()
        `when`(repository.save(ticket)).thenReturn(ticket.copy(id = 1))

        val actual = subject.save(dto)
        verify(repository).save(ticket)
        verifyNoMoreInteractions(repository)
        assertNotNull(actual.itineraryId)
    }
}