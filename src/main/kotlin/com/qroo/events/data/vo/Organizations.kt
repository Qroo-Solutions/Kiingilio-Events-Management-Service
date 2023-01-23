package com.qroo.events.data.vo

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "kiingilio_organizations")
public final data class Organizations(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) var id: Long,
    val name: String,
    val phoneNumber: String,
    val emailAddress: String,
    val logo: String,
    val banner: String,
    val description: String,
    val active: Boolean,
    val userId: Long,
    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    val createdDate: Date,
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    val updatedDate: Date,
)