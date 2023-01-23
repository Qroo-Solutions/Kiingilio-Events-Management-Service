package com.qroo.events

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class EventsManagementApplication

fun main(args: Array<String>) {
    runApplication<EventsManagementApplication>(*args)
}
