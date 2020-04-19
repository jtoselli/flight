package com.jtoselli.flight.api

import com.jtoselli.flight.dto.TicketDto

interface TicketApi {
    fun findById(id: Int): TicketDto
    fun save(ticketDto: TicketDto): TicketDto
}