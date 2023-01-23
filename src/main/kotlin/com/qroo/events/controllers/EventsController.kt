package com.qroo.events.controllers

import com.qroo.events.data.vo.Event
import com.qroo.events.services.EventsService
import org.springframework.stereotype.Controller

@Controller
class EventsController(val service: EventsService) {
    fun getAllEvents() = service.getAll()
    fun getEvent(id: Long) = service.getById(id)
    fun createEvent(event: Event): Event = service.create(event)
    fun deleteEvent(id: Long) = service.remove(id)
    fun updateEvent(id: Long, event: Event) = service.update(id, event)
}