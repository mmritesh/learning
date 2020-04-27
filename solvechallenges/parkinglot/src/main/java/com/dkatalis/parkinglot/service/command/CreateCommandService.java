package com.dkatalis.parkinglot.service.command;

import com.dkatalis.parkinglot.service.ParkingLotService;
import com.dkatalis.parkinglot.util.constant.ApplicationConstants;
import com.dkatalis.parkinglot.util.constant.CommandsEnum;

/**
 * Created by Abhilash Kale on 11-04-2020.
 */
public class CreateCommandService extends CommandService {

  private ParkingLotService parkingLotService;

  public CreateCommandService(ParkingLotService parkingLotService) {
    checkIfParkingLotServiceEmptyAndThrowException(parkingLotService);
    this.parkingLotService = parkingLotService;
  }

  @Override
  public void process(String... commandArguments) {
    if (isCommandArgumentsInvalid(commandArguments)) {
      throwInputCommandProcessException(CommandsEnum.CREATE_PARKING_LOT);
    }
    createParkingLotAndDisplayMessage(commandArguments[0]);
  }

  private void createParkingLotAndDisplayMessage(String totalSlotsInString) {
    int totalSlots = Integer.parseInt(totalSlotsInString);
    parkingLotService.createParkingSlot(totalSlots);
    System.out.println("Created parking lot with " + totalSlots + " slots");
  }

  public boolean isCommandArgumentsInvalid(String[] commandArguments) {
    return commandArguments.length < ApplicationConstants.ONE || commandArguments[ApplicationConstants.ZERO]
        .equals(ApplicationConstants.BLANK);
  }
}
