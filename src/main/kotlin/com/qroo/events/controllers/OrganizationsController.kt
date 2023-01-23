package com.qroo.events.controllers

import com.qroo.events.data.vo.Organizations
import com.qroo.events.services.OrganizationsService
import org.springframework.stereotype.Controller

@Controller
class OrganizationsController(val service: OrganizationsService) {
    fun getAllOrganizations() = service.getAll()
    fun geOrganization(id: Long) = service.getById(id)
    fun createOrganization(organizations: Organizations): Organizations = service.create(organizations)
    fun deleteOrganization(id: Long) = service.remove(id)
    fun updateOrganization(id: Long, organization: Organizations) = service.update(id, organization)
}