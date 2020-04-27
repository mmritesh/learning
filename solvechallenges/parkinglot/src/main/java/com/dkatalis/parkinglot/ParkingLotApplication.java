package com.dkatalis.parkinglot;

import com.dkatalis.parkinglot.service.input.FileInputService;
import com.dkatalis.parkinglot.service.input.UserInputService;

/**
 * Created by Abhilash Kale on 11-04-2020.
 */
public class ParkingLotApplication {

  public static void main(String[] commandLineArguments) {
    processUserInput(commandLineArguments);
  }

  private static void processUserInput(String[] commandLineArguments) {
    UserInputService userInputService = null;
    if (isFileInputProvided(commandLineArguments)) {
      userInputService = new FileInputService(commandLineArguments[0]);
    }
    invokeUserInputProcessor(userInputService);
  }

  private static void invokeUserInputProcessor(UserInputService userInputService) {
    try {
      userInputService.processUserInput();
    } catch (NullPointerException exception) {
      System.out.println("Please provide input data source for the parking lot application");
    }
  }

  private static boolean isFileInputProvided(String[] commandLineArguments) {
    return commandLineArguments.length >= 1;
  }
}
