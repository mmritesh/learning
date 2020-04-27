package com.dkatalis.parkinglot.service.input;

import static com.dkatalis.parkinglot.util.constant.CommandsEnum.getCommand;

import com.dkatalis.parkinglot.exception.InputCommandProcessException;
import com.dkatalis.parkinglot.service.ParkingLotService;
import com.dkatalis.parkinglot.service.command.CommandService;
import com.dkatalis.parkinglot.service.command.CreateCommandService;
import com.dkatalis.parkinglot.service.command.LeaveCommandService;
import com.dkatalis.parkinglot.service.command.ParkCommandService;
import com.dkatalis.parkinglot.service.command.StatusCommandService;
import com.dkatalis.parkinglot.util.constant.ApplicationConstants;
import com.dkatalis.parkinglot.util.constant.CommandsEnum;
import java.util.Arrays;

/**
 * Created by Abhilash Kale on 11-04-2020.
 */
public abstract class UserInputService {

  private ParkingLotService parkingLotService;

  public abstract void processUserInput();

  public void validateAndProcess(String userInput) {
    String[] userInputArray = userInput.split(" ");
    if (isEmptyOrInvalidCommand(userInputArray)) {
      throwInvalidCommandException();
    }
    processUserInputBasedOnCommands(userInputArray);
  }

  private boolean isEmptyOrInvalidCommand(String[] userInputArray) {
    return userInputArray.length == ApplicationConstants.ZERO;
  }

  private void processUserInputBasedOnCommands(String[] userInputArray) {
    CommandsEnum command = getCommand(userInputArray);
    CommandService commandService = null;
    switch (command) {
      case CREATE_PARKING_LOT:
        commandService = initializeParkingLotServiceAndGetCreateCommand();
        break;
      case PARK:
        commandService = new ParkCommandService(parkingLotService);
        break;
      case LEAVE:
        commandService = new LeaveCommandService(parkingLotService);
        break;
      case STATUS:
        commandService = new StatusCommandService(parkingLotService);
        break;
      default:
        throwInvalidCommandException();
    }
    commandService.process(Arrays.copyOfRange(userInputArray, 1, userInputArray.length));

  }

  private void throwInvalidCommandException() {
    throw new InputCommandProcessException("Invalid command provided.");
  }

  private CommandService initializeParkingLotServiceAndGetCreateCommand() {
    CommandService commandService;
    parkingLotService = new ParkingLotService();
    commandService = new CreateCommandService(parkingLotService);
    return commandService;
  }
}
