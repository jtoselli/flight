package com.jtoselli.flight.rest

import com.jtoselli.flight.dto.TicketDto
import com.jtoselli.flight.service.TicketNotFoundException
import com.jtoselli.flight.service.TicketService
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
internal class TicketResourceTest {
    @Mock
    private lateinit var ticketService: TicketService

    @InjectMocks
    private lateinit var subject: TicketResource

    @Test
    fun `test findById returns proper result`() {
        // arrange
        val id = 1
        val expected = TicketDto.build(itineraryId = id)
        `when`(ticketService.findById(id)).thenReturn(expected)

        // act
        val actual = subject.findById(id)

        // assert
        assertEquals(expected, actual)
    }

    @Test
    fun `test findById throws proper exception`() {
        // arrange
        val id = 1
        `when`(ticketService.findById(id)).thenThrow(TicketNotFoundException::class.java)

        // act & assert
        assertThrows<TicketNotFoundException> { subject.findById(id) }
    }

    @Test
    fun `test save produces proper result`() {
        // arrange
        val original = TicketDto.build()
        val expected = original.copy(itineraryId = 1)
        `when`(ticketService.save(original)).thenReturn(expected)

        // act
        val actual = subject.save(original)

        assertEquals(expected, actual)
    }

    @Test
    fun `test save propagates exception`() {
        val original = TicketDto.build();
        `when`(ticketService.save(original)).thenThrow(RuntimeException::class.java)

        assertThrows<RuntimeException> { subject.save(original) }
    }
}