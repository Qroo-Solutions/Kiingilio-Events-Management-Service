package com.qroo.events.controllers

import com.qroo.events.data.vo.Tickets
import com.qroo.events.services.TicketsService
import org.springframework.stereotype.Controller

@Controller
class TicketsController(val service: TicketsService) {
    fun getAllTickets() = service.getAll()
    fun geTicket(id: Long) = service.getById(id)
    fun createTicket(ticket: Tickets): Tickets = service.create(ticket)
    fun deleteTicket(id: Long) = service.remove(id)
    fun updateTicket(id: Long, ticket: Tickets) = service.update(id, ticket)
}