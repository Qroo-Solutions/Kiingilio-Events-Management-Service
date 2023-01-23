package com.qroo.events.data.dao

import com.qroo.events.data.vo.Tickets
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TicketsRepository : JpaRepository<Tickets, Long>