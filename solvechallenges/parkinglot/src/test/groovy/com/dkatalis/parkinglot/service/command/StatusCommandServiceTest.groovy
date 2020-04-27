package com.dkatalis.parkinglot.service.command

import com.dkatalis.parkinglot.exception.InputCommandProcessException
import com.dkatalis.parkinglot.service.ParkingLotService
import spock.lang.Specification

/**
 * Created by Abhilash Kale on 12-04-2020.
 */
class StatusCommandServiceTest extends Specification {
    def customOutputStreamContent
    def originalOutputStreamContent
    def statusCommandService
    def parkingLotService

    def setup() {
        setCustomAndOriginalOutputStream()
        parkingLotService = Mock(ParkingLotService)
        statusCommandService = new StatusCommandService(parkingLotService)
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
        parkingLotService.validateParkingLotDetailsAndDisplayStatus(_) >> null
        when: "Invoking method"
        statusCommandService.process("")

        then: "It should throw InputCommandProcessException"
        thrown(InputCommandProcessException)
    }

    def "test process method for success scenario"() {
        given: "Mock data"
        parkingLotService.validateParkingLotDetailsAndDisplayStatus(_) >> null
        when: "Invoking method"
        statusCommandService.process()

        then: "No exception should be thrown"
        noExceptionThrown()
    }
}
