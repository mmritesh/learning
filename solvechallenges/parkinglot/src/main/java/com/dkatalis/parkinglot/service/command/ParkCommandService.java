package com.dkatalis.parkinglot.service.command;

import com.dkatalis.parkinglot.model.Car;
import com.dkatalis.parkinglot.model.Vehicle;
import com.dkatalis.parkinglot.service.ParkingLotService;
import com.dkatalis.parkinglot.util.constant.ApplicationConstants;
import com.dkatalis.parkinglot.util.constant.CommandsEnum;

/**
 * Created by Abhilash Kale on 11-04-2020.
 */
public class ParkCommandService extends CommandService {

  private ParkingLotService parkingLotService;

  public ParkCommandService(ParkingLotService parkingLotService) {
    checkIfParkingLotServiceEmptyAndThrowException(parkingLotService);
    this.parkingLotService = parkingLotService;
  }

  @Override
  public void process(String... commandArguments) {
    if (isCommandArgumentsInvalid(commandArguments)) {
      throwInputCommandProcessException(CommandsEnum.PARK);
    }
    parkVehicle(commandArguments);
  }

  @Override
  public boolean isCommandArgumentsInvalid(String[] commandArguments) {
    return commandArguments.length < ApplicationConstants.ONE || commandArguments[ApplicationConstants.ZERO]
        .equals(ApplicationConstants.BLANK);
  }

  private void parkVehicle(String[] commandArguments) {
    Vehicle vehicle = getVehicleInstanceBasedOnCommandArguments(commandArguments);
    parkingLotService.parkVehicle(vehicle);
  }

  private Vehicle getVehicleInstanceBasedOnCommandArguments(String[] commandArguments) {
    Vehicle vehicle = new Car();
    vehicle.setRegistrationNumber(commandArguments[ApplicationConstants.ZERO]);
    return vehicle;
  }
}
