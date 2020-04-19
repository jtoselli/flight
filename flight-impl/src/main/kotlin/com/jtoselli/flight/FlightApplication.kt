package com.jtoselli.flight

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class FlightApplication

fun main(args: Array<String>) {
	runApplication<FlightApplication>(*args)
}
