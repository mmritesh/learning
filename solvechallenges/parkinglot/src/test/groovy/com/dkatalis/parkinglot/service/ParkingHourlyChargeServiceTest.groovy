package com.dkatalis.parkinglot.service

import com.dkatalis.parkinglot.exception.InvalidParkingDurationException
import spock.lang.Specification

/**
 * Created by Abhilash Kale on 13-04-2020.
 */
class ParkingHourlyChargeServiceTest extends Specification {

    def parkingHourlyChargeService

    def setup() {
        parkingHourlyChargeService = new ParkingHourlyChargeService()
    }

    def "test getCharge method for first 1 hour"() {
        when: "Invoking method"
        def totalCharge = parkingHourlyChargeService.getCharge(1)

        then: "It should return 10"
        totalCharge == 10
    }

    def "test getCharge method for first 2 hour"() {
        when: "Invoking method"
        def totalCharge = parkingHourlyChargeService.getCharge(2)

        then: "It should return 10"
        totalCharge == 10
    }

    def "test getCharge method for 3 hour"() {
        when: "Invoking method"
        def totalCharge = parkingHourlyChargeService.getCharge(3)

        then: "It should return 20"
        totalCharge == 20
    }

    def "test getCharge method for failure scenario or total hour as 0"() {
        when: "Invoking method"
        parkingHourlyChargeService.getCharge(0)

        then: "It should throw InvalidParkingDurationException"
        thrown(InvalidParkingDurationException)
    }

    def "test getCharge method for failure scenario or total hour as negative number"() {
        when: "Invoking method"
        parkingHourlyChargeService.getCharge(-1)

        then: "It should throw InvalidParkingDurationException"
        thrown(InvalidParkingDurationException)
    }
}
