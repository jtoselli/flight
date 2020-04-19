package com.jtoselli.flight.rest

import com.jtoselli.flight.api.TicketApi
import com.jtoselli.flight.dto.TicketDto
import com.jtoselli.flight.service.TicketService
import org.springframework.web.bind.annotation.*
import javax.inject.Inject
import javax.validation.Valid

@RestController
@RequestMapping("/tickets")
class TicketResource @Inject constructor(private val ticketService: TicketService) : TicketApi {
    @GetMapping("/{id}")
    override fun findById(@PathVariable id: Int) = ticketService.findById(id)

    @PostMapping
    override fun save(@RequestBody @Valid ticketDto: TicketDto) = ticketService.save(ticketDto)
}