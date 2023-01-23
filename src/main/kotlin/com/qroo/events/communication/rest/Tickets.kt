package com.qroo.events.communication.rest

import com.qroo.events.controllers.TicketsController
import com.qroo.events.data.vo.Tickets
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/tickets")
class Tickets (val controller: TicketsController) {
    @GetMapping
    fun getTickets() = controller.getAllTickets()

    @GetMapping("/{id}")
    fun getTicket(@PathVariable id: Long) = controller.geTicket(id)

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun saveTicket(@RequestBody ticket: Tickets): Tickets = controller.createTicket(ticket)

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteEvent(@PathVariable id: Long) = controller.deleteTicket(id)

    @PutMapping("/{id}")
    fun updateEvent(
        @PathVariable id: Long, @RequestBody ticket: Tickets
    ) = controller.updateTicket(id, ticket)
}