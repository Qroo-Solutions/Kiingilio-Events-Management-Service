package com.qroo.events.communication.rest

import com.qroo.events.controllers.OrganizationsController
import com.qroo.events.data.vo.Organizations
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/organizations")
class Organizations (val controller: OrganizationsController) {
    @GetMapping
    fun getOrganizations() = controller.getAllOrganizations()

    @GetMapping("/{id}")
    fun getOrganization(@PathVariable id: Long) = controller.geOrganization(id)

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun saveOrganization(@RequestBody organization: Organizations): Organizations = controller.createOrganization(organization)

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteEvent(@PathVariable id: Long) = controller.deleteOrganization(id)

    @PutMapping("/{id}")
    fun updateEvent(
        @PathVariable id: Long, @RequestBody organization: Organizations
    ) = controller.updateOrganization(id, organization)
}