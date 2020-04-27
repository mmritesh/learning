package com.dkatalis.parkinglot.service.command

import com.dkatalis.parkinglot.exception.InputCommandProcessException
import com.dkatalis.parkinglot.exception.VehicleNotFoundException
import com.dkatalis.parkinglot.model.Car
import com.dkatalis.parkinglot.model.ParkingSpot
import com.dkatalis.parkinglot.service.ParkingChargeService
import com.dkatalis.parkinglot.service.ParkingLotService
import spock.lang.Specification

/**
 * Created by Abhilash Kale on 12-04-2020.
 */
class LeaveCommandServiceTest extends Specification {
    def customOutputStreamContent
    def originalOutputStreamContent
    def leaveCommandService
    def parkingLotService
    def parkingChargeService

    def setup() {
        setCustomAndOriginalOutputStream()
        parkingLotService = Mock(ParkingLotService)
        parkingChargeService = Mock(ParkingChargeService)
        leaveCommandService = new LeaveCommandService(parkingLotService)
        System.setOut(new PrintStream(customOutputStreamContent));
    }

    def setCustomAndOriginalOutputStream() {
        customOutputStreamContent = new ByteArrayOutputStream()
        originalOutputStreamContent = System.out;
    }

    def cleanup() {
        System.setOut(originalOutputStreamContent);
    }

    def "test process method for InputCommandProcessException occurrence"() {
        given: "Mock data"
        parkingLotService.leaveSlot(_) >> null
        when: "Invoking method"
        leaveCommandService.process("", "1")

        then: "It should throw InputCommandProcessException"
        thrown(InputCommandProcessException)
    }

    def "test process method for success scenario"() {
        given: "Mock data"
        def vehicle = new Car()
        vehicle.setRegistrationNumber("ABC")
        def parkingSpot = new ParkingSpot(1, vehicle)
        parkingLotService.leaveSlot(_) >> parkingSpot
        when: "Invoking method"
        leaveCommandService.process("KA-01-HH-3141", "4")

        then: "It should print slot leave message"
        customOutputStreamContent.toString().equals("Registration number ABC with Slot Number 1 is free with Charge 30\n")
    }

    def "test process method for VehicleNotFoundException occurrence"() {
        given: "Mock data"
        parkingLotService.leaveSlot(_) >> { throw new VehicleNotFoundException("test exception message") }
        when: "Invoking method"
        leaveCommandService.process("KA-01-HH-3141", "4")
        then: "It should print VehicleNotFoundException message"
        customOutputStreamContent.toString().equals("Registration number KA-01-HH-3141 not found\n")
    }
}
