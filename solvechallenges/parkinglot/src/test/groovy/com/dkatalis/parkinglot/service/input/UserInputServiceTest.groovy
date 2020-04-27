package com.dkatalis.parkinglot.service.input

import com.dkatalis.parkinglot.exception.InputCommandProcessException
import com.dkatalis.parkinglot.exception.ParkingLotException
import spock.lang.Specification

/**
 * Created by Abhilash Kale on 12-04-2020.
 */
class UserInputServiceTest extends Specification {
    def customOutputStreamContent
    def originalOutputStreamContent
    def userInputService

    def setup() {
        setCustomAndOriginalOutputStream()
        userInputService = new FileInputService("file_input.txt",)
        System.setOut(new PrintStream(customOutputStreamContent));
    }

    def setCustomAndOriginalOutputStream() {
        customOutputStreamContent = new ByteArrayOutputStream()
        originalOutputStreamContent = System.out;
    }

    def cleanup() {
        System.setOut(originalOutputStreamContent);
    }

    def "test validateAndProcess method for InputCommandProcessException occurrence for empty or invalid command"() {
        when: "Invoking method"
        userInputService.validateAndProcess(" ")

        then: "It should throw InputCommandProcessException"
        thrown(InputCommandProcessException)
    }

    def "test validateAndProcess method for no exception occurrence for create_parking_lot command"() {
        when: "Invoking method"
        userInputService.validateAndProcess("create_parking_lot 6")

        then: "It should not throw exception"
        noExceptionThrown()
    }

    def "test validateAndProcess method for no exception occurrence for park command"() {
        when: "Invoking method"
        userInputService.validateAndProcess("park KA-01-HH-9999")

        then: "It should throw ParkingLotException"
        thrown(ParkingLotException)
    }

    def "test validateAndProcess method for no exception occurrence for leave command"() {
        when: "Invoking method"
        userInputService.validateAndProcess("leave KA-01-HH-3141 4")

        then: "It should throw ParkingLotException"
        thrown(ParkingLotException)
    }

    def "test validateAndProcess method for no exception occurrence for status command"() {
        when: "Invoking method"
        userInputService.validateAndProcess("status")

        then: "It should throw ParkingLotException"
        thrown(ParkingLotException)
    }
}
