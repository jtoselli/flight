package com.jtoselli.flight.service

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(HttpStatus.NOT_FOUND)
class TicketNotFoundException() : RuntimeException("The requested ticket was not found")