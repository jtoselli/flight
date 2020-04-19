package com.jtoselli.flight.model.repository

import com.jtoselli.flight.model.Ticket
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface TicketRepository : CrudRepository<Ticket, Int>