package com.qroo.events.data.vo

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import java.util.*
import jakarta.persistence.*

@Entity
@Table(name = "kiingilio_tickets")
public final data class Tickets(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) var id: Long,
    @ManyToOne(fetch = FetchType.LAZY)
    val event: Event,
    val title: String,
    val minimum: Integer,
    val maximum: Integer,
    val total: Integer,
    val amount: Double,
    val startDate: Date,
    val endDate: Date,
    val active: Boolean,
    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    val createdDate: Date,
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    val updatedDate: Date
)