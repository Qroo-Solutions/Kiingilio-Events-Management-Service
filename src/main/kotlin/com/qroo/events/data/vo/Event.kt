package com.qroo.events.data.vo

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import java.util.*
import jakarta.persistence.*
import lombok.Getter
import lombok.NoArgsConstructor
import lombok.RequiredArgsConstructor
import lombok.Setter

@Entity
@NoArgsConstructor
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "kiingilio_events")
data class Event(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) var id: Long,
    @ManyToOne(fetch = FetchType.LAZY)
    val organization: Organizations,
    val title: String,
    val shortDescription: String,
    val fullDescription: String,
    val longitude: String,
    val latitude: String,
    val location: String,
    val venue: String,
    val startDate: Date,
    val endDate: Date,
    val bannerImage: String,
    val smallImage: String,
    val phoneNumber: String,
    val emailAddress: String,
    val url: String,
    val eventType: String,
    val status: Boolean,
    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    val createdDate: Date,
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    val updatedDate: Date,
)