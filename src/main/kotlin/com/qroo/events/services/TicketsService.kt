package com.qroo.events.services

import com.qroo.events.data.dao.TicketsRepository
import com.qroo.events.data.vo.Tickets
import org.springframework.data.repository.findByIdOrNull
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class TicketsService(val repository: TicketsRepository) {
    fun getAll(): List<Tickets> = repository.findAll()

    fun getById(id: Long): Tickets = repository.findByIdOrNull(id) ?:
    throw ResponseStatusException(HttpStatus.NOT_FOUND)

    fun create(ticket: Tickets): Tickets = repository.save(ticket)

    fun remove(id: Long) {
        if (repository.existsById(id)) repository.deleteById(id)
        else throw ResponseStatusException(HttpStatus.NOT_FOUND)
    }

    fun update(id: Long, ticket: Tickets): Tickets {
        return if (repository.existsById(id)) {
            ticket.id = id
            repository.save(ticket)
        } else throw ResponseStatusException(HttpStatus.NOT_FOUND)
    }
}