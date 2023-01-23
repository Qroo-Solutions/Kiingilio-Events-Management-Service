package com.qroo.events.services

import com.qroo.events.data.dao.EventsRepository
import com.qroo.events.data.vo.Event
import org.springframework.data.repository.findByIdOrNull
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class EventsService(val repository: EventsRepository) {
    fun getAll(): List<Event> = repository.findAll()

    fun getById(id: Long): Event = repository.findByIdOrNull(id) ?:
    throw ResponseStatusException(HttpStatus.NOT_FOUND)

    fun create(event: Event): Event = repository.save(event)

    fun remove(id: Long) {
        if (repository.existsById(id)) repository.deleteById(id)
        else throw ResponseStatusException(HttpStatus.NOT_FOUND)
    }

    fun update(id: Long, event: Event): Event {
        return if (repository.existsById(id)) {
            event.id = id
            repository.save(event)
        } else throw ResponseStatusException(HttpStatus.NOT_FOUND)
    }
}