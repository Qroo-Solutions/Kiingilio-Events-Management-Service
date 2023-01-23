package com.qroo.events.data.dao

import com.qroo.events.data.vo.Organizations
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface OrganizationsRepository : JpaRepository<Organizations, Long>