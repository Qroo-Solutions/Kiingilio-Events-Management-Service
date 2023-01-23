package com.qroo.events.services

import com.qroo.events.data.dao.OrganizationsRepository
import com.qroo.events.data.vo.Organizations
import org.springframework.data.repository.findByIdOrNull
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class OrganizationsService(val repository: OrganizationsRepository) {
    fun getAll(): List<Organizations> = repository.findAll()

    fun getById(id: Long): Organizations = repository.findByIdOrNull(id) ?:
    throw ResponseStatusException(HttpStatus.NOT_FOUND)

    fun create(organizations: Organizations): Organizations = repository.save(organizations)

    fun remove(id: Long) {
        if (repository.existsById(id)) repository.deleteById(id)
        else throw ResponseStatusException(HttpStatus.NOT_FOUND)
    }

    fun update(id: Long, organizations: Organizations): Organizations {
        return if (repository.existsById(id)) {
            organizations.id = id
            repository.save(organizations)
        } else throw ResponseStatusException(HttpStatus.NOT_FOUND)
    }
}