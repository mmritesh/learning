package com.dkatalis.parkinglot

import spock.lang.Specification

/**
 * Created by Abhilash Kale on 11-04-2020.
 */
class ParkingLotApplicationTest extends Specification {

    def customOutputStreamContent
    def originalOutputStreamContent

    def setup() {
        customOutputStreamContent = new ByteArrayOutputStream()
        originalOutputStreamContent = System.out;
        System.setOut(new PrintStream(customOutputStreamContent));
    }

    def cleanup() {
        System.setOut(originalOutputStreamContent);
    }

    def "test main() method for FileInputService for no data source exception"() {
        when: "main method is invoked"
        ParkingLotApplication.main()

        then: "no exception is thrown"
        customOutputStreamContent.toString().equals("Please provide input data source for the parking lot application\n")
    }
}
