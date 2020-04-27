package com.dkatalis.parkinglot.service.command;

import com.dkatalis.parkinglot.service.ParkingLotService;
import com.dkatalis.parkinglot.util.constant.ApplicationConstants;
import com.dkatalis.parkinglot.util.constant.CommandsEnum;

/**
 * Created by Abhilash Kale on 12-04-2020.
 */
public class StatusCommandService extends CommandService {

  private ParkingLotService parkingLotService;

  public StatusCommandService(ParkingLotService parkingLotService) {
    checkIfParkingLotServiceEmptyAndThrowException(parkingLotService);
    this.parkingLotService = parkingLotService;
  }

  @Override
  public void process(String... commandArguments) {
    if (isCommandArgumentsInvalid(commandArguments)) {
      throwInputCommandProcessException(CommandsEnum.STATUS);
    }
    this.parkingLotService.validateParkingLotDetailsAndDisplayStatus();
  }

  @Override
  public boolean isCommandArgumentsInvalid(String[] commandArguments) {
    return commandArguments.length > ApplicationConstants.ZERO;
  }
}
