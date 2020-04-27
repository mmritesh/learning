package com.dkatalis.parkinglot.service.command;

import com.dkatalis.parkinglot.exception.VehicleNotFoundException;
import com.dkatalis.parkinglot.model.ParkingSpot;
import com.dkatalis.parkinglot.service.ParkingChargeService;
import com.dkatalis.parkinglot.service.ParkingHourlyChargeService;
import com.dkatalis.parkinglot.service.ParkingLotService;
import com.dkatalis.parkinglot.util.constant.ApplicationConstants;
import com.dkatalis.parkinglot.util.constant.CommandsEnum;

/**
 * Created by Abhilash Kale on 11-04-2020.
 */
public class LeaveCommandService extends CommandService {

  private ParkingLotService parkingLotService;
  private ParkingChargeService parkingChargeService;

  public LeaveCommandService(ParkingLotService parkingLotService) {
    checkIfParkingLotServiceEmptyAndThrowException(parkingLotService);
    this.parkingLotService = parkingLotService;
    this.parkingChargeService = new ParkingHourlyChargeService();
  }

  @Override
  public void process(String... commandArguments) {
    if (isCommandArgumentsInvalid(commandArguments)) {
      throwInputCommandProcessException(CommandsEnum.LEAVE);
    }
    performLeaveParkingLotOperations(commandArguments);
  }

  @Override
  public boolean isCommandArgumentsInvalid(String[] commandArguments) {
    return commandArguments.length < ApplicationConstants.TWO || isArgumentsBlank(commandArguments);
  }

  private void performLeaveParkingLotOperations(String[] commandArguments) {
    try {
      ParkingSpot parkingSpot = parkingLotService.leaveSlot(commandArguments[ApplicationConstants.ZERO]);
      displayVehicleSlotAndChargeDetails(parkingSpot, commandArguments[ApplicationConstants.ONE]);
    } catch (VehicleNotFoundException vehicleNotFoundException) {
      System.out.println("Registration number " + commandArguments[ApplicationConstants.ZERO] + " not found");
    }
  }

  private void displayVehicleSlotAndChargeDetails(ParkingSpot parkingSpot, String charge) {
    System.out.println("Registration number " + parkingSpot.getVehicle().getRegistrationNumber()
        + " with Slot Number " + parkingSpot.getSlotNumber() + " is free with Charge "
        + parkingChargeService.getCharge(Integer.parseInt(charge)));
  }

  private boolean isArgumentsBlank(String[] commandArguments) {
    return commandArguments[ApplicationConstants.ZERO].equals(ApplicationConstants.BLANK)
        || commandArguments[ApplicationConstants.ONE].equals(ApplicationConstants.BLANK);
  }

}
