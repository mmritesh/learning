package com.dkatalis.parkinglot.service.command;

import com.dkatalis.parkinglot.exception.InputCommandProcessException;
import com.dkatalis.parkinglot.exception.ParkingLotException;
import com.dkatalis.parkinglot.service.ParkingLotService;
import com.dkatalis.parkinglot.util.constant.CommandsEnum;
import java.util.Objects;

/**
 * Created by Abhilash Kale on 11-04-2020.
 */
public abstract class CommandService {

  public abstract void process(final String... commandArguments);

  public abstract boolean isCommandArgumentsInvalid(String[] commandArguments);

  protected void throwInputCommandProcessException(CommandsEnum command) {
    throw new InputCommandProcessException("Invalid no of arguments for command : " + command.getValue());
  }

  protected void checkIfParkingLotServiceEmptyAndThrowException(ParkingLotService parkingLotService) {
    if(Objects.isNull(parkingLotService)){
      throw new ParkingLotException("Parking lot service instance cannot be empty. Please create and try again");
    }
  }
}
