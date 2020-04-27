package com.dkatalis.parkinglot.service.input


import spock.lang.Specification

/**
 * Created by Abhilash Kale on 12-04-2020.
 */
class FileInputServiceTest extends Specification {
    def customOutputStreamContent
    def originalOutputStreamContent
    def fileInputService

    def setup() {
        setCustomAndOriginalOutputStream()
        fileInputService = new FileInputService("file_input.txt")
        System.setOut(new PrintStream(customOutputStreamContent));
    }

    def setCustomAndOriginalOutputStream() {
        customOutputStreamContent = new ByteArrayOutputStream()
        originalOutputStreamContent = System.out;
    }

    def cleanup() {
        System.setOut(originalOutputStreamContent);
    }

    def "test processUserInput method for no exception occurrence"() {
        when: "Invoking method"
        fileInputService.processUserInput()

        then: "It should not throw exception"
        noExceptionThrown()
    }

    def "test processUserInput method for exception occurrence"() {
        given: "Preparing mock data"
        fileInputService = new FileInputService("")

        when: "Invoking method"
        fileInputService.processUserInput()

        then: "Exception is caught and logged which is checked below"
        customOutputStreamContent.toString().equals("Exception occurred while reading file contents. Please try again\n")
    }

}
