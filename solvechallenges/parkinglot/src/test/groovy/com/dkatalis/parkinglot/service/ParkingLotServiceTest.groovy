package com.dkatalis.parkinglot.service

import com.dkatalis.parkinglot.exception.EmptyParkingLotException
import com.dkatalis.parkinglot.exception.VehicleNotFoundException
import com.dkatalis.parkinglot.model.Car
import com.dkatalis.parkinglot.model.ParkingLot
import spock.lang.Specification

/**
 * Created by Abhilash Kale on 13-04-2020.
 */
class ParkingLotServiceTest extends Specification {
    def customOutputStreamContent
    def originalOutputStreamContent
    def parkingLotService
    def parkingLot

    def setup() {
        setCustomAndOriginalOutputStream()
        System.setOut(new PrintStream(customOutputStreamContent));
    }

    def setCustomAndOriginalOutputStream() {
        customOutputStreamContent = new ByteArrayOutputStream()
        originalOutputStreamContent = System.out;
    }

    def cleanup() {
        System.setOut(originalOutputStreamContent);
    }

    def "test parkVehicle method for success scenario"() {
        given: "Mock data"
        def vehicle = new Car()
        vehicle.setRegistrationNumber("ABC")
        parkingLot = new ParkingLot(6)
        parkingLotService = new ParkingLotService(parkingLot: parkingLot)
        when: "Invoking method"
        parkingLotService.parkVehicle(vehicle)

        then: "It should print slot allocation message"
        customOutputStreamContent.toString().equals("Allocated slot number: 1\n")
    }

    def "test parkVehicle method for parking lot not created scenario"() {
        given: "Mock data"
        def vehicle = new Car()
        vehicle.setRegistrationNumber("ABC")
        parkingLotService = new ParkingLotService(parkingLot: parkingLot)
        when: "Invoking method"
        parkingLotService.parkVehicle(vehicle)

        then: "It should print parking lot not created message"
        customOutputStreamContent.toString().equals("Sorry, parking lot is not created\n")
    }

    def "test parkVehicle method for parking lot full scenario"() {
        given: "Mock data"
        def vehicle = new Car()
        vehicle.setRegistrationNumber("ABC")
        parkingLot = new ParkingLot(1)
        parkingLot.getSlotVehicleMap().put(1, vehicle)
        parkingLotService = new ParkingLotService(parkingLot: parkingLot)
        when: "Invoking method"
        parkingLotService.parkVehicle(vehicle)

        then: "It should print parking lot full message"
        customOutputStreamContent.toString().equals("Sorry, parking lot is full\n")
    }

    def "test createParkingSlot method for success scenario"() {
        given: "Mock data"
        def vehicle = new Car()
        vehicle.setRegistrationNumber("ABC")
        parkingLot = new ParkingLot(1)
        parkingLotService = new ParkingLotService(parkingLot: parkingLot)
        when: "Invoking method"
        parkingLotService.createParkingSlot(1)

        then: "availableSlotQueue size should be 1"
        parkingLot.getAvailableSlotQueue().size() == 1
    }

    def "test createParkingSlot method for failure scenario"() {
        given: "Mock data"
        def vehicle = new Car()
        vehicle.setRegistrationNumber("ABC")
        parkingLotService = new ParkingLotService(parkingLot: parkingLot)
        when: "Invoking method"
        parkingLotService.createParkingSlot(0)

        then: "It should throw EmptyParkingLotException"
        thrown(EmptyParkingLotException)
    }

    def "test leaveSlot method for success scenario"() {
        given: "Mock data"
        def vehicle1 = new Car()
        vehicle1.setRegistrationNumber("ABC")
        def vehicle2 = new Car()
        vehicle2.setRegistrationNumber("BCD")
        parkingLot = new ParkingLot(2)
        parkingLot.getSlotVehicleMap().put(1, vehicle1)
        parkingLot.getSlotVehicleMap().put(2, vehicle2)
        parkingLotService = new ParkingLotService(parkingLot: parkingLot)
        when: "Invoking method"
        def parkingSpot = parkingLotService.leaveSlot("BCD")

        then: "It should return non-null parking spot object with valid details"
        Objects.nonNull(parkingSpot)
        parkingSpot.getSlotNumber() == 2
        parkingSpot.getVehicle().getRegistrationNumber().equals("BCD")
    }

    def "test leaveSlot method for failure scenario"() {
        given: "Mock data"
        def vehicle1 = new Car()
        vehicle1.setRegistrationNumber("ABC")
        def vehicle2 = new Car()
        vehicle2.setRegistrationNumber("BCD")
        parkingLot = new ParkingLot(2)
        parkingLot.getSlotVehicleMap().put(1, vehicle1)
        parkingLot.getSlotVehicleMap().put(2, vehicle2)
        parkingLotService = new ParkingLotService(parkingLot: parkingLot)
        when: "Invoking method"
        parkingLotService.leaveSlot("A")

        then: "It should throw VehicleNotFoundException"
        thrown(VehicleNotFoundException)
    }

    def "test validateParkingLotDetailsAndDisplayStatus method for failure scenario"() {
        given: "Mock data"
        parkingLot = new ParkingLot(2)
        parkingLotService = new ParkingLotService(parkingLot: parkingLot)
        when: "Invoking method"
        parkingLotService.validateParkingLotDetailsAndDisplayStatus()

        then: "It should throw EmptyParkingLotException"
        thrown(EmptyParkingLotException)
    }
}
