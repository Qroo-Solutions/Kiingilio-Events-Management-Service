package com.qroo.events.data.dao

import com.qroo.events.data.vo.Event
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface EventsRepository : JpaRepository<Event, Long>