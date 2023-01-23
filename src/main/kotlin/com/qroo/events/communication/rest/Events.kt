package com.qroo.events.communication.rest

import com.qroo.events.controllers.EventsController
import com.qroo.events.data.vo.Event
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/events")
class Events (val controller: EventsController) {
    @GetMapping
    fun getEvents() = controller.getAllEvents()

    @GetMapping("/{id}")
    fun getEvent(@PathVariable id: Long) = controller.getEvent(id)

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun saveEvent(@RequestBody event: Event): Event = controller.createEvent(event)

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteEvent(@PathVariable id: Long) = controller.deleteEvent(id)

    @PutMapping("/{id}")
    fun updateEvent(
        @PathVariable id: Long, @RequestBody event: Event
    ) = controller.updateEvent(id, event)
}