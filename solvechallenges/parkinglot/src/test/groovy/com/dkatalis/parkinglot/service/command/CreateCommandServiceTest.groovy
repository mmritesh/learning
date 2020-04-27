package com.dkatalis.parkinglot.service.command

import com.dkatalis.parkinglot.exception.InputCommandProcessException
import com.dkatalis.parkinglot.service.ParkingLotService
import spock.lang.Specification

/**
 * Created by Abhilash Kale on 12-04-2020.
 */
class CreateCommandServiceTest extends Specification {
    def customOutputStreamContent
    def originalOutputStreamContent
    def createCommandService
    def parkingLotService

    def setup() {
        setCustomAndOriginalOutputStream()
        parkingLotService = Mock(ParkingLotService)
        createCommandService = new CreateCommandService(parkingLotService)
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
        parkingLotService.createParkingSlot(_) >> null
        when: "Invoking method"
        createCommandService.process("")

        then: "It should throw InputCommandProcessException"
        thrown(InputCommandProcessException)
    }

    def "test process method for success scenario"() {
        given: "Mock data"
        parkingLotService.createParkingSlot(_) >> null
        when: "Invoking method"
        createCommandService.process("6")

        then: "It should print parking lot created message"
        customOutputStreamContent.toString().equals("Created parking lot with 6 slots\n")
    }
}
