package com.dkatalis.parkinglot.service;

import com.dkatalis.parkinglot.exception.EmptyParkingLotException;
import com.dkatalis.parkinglot.exception.VehicleNotFoundException;
import com.dkatalis.parkinglot.model.ParkingLot;
import com.dkatalis.parkinglot.model.ParkingSpot;
import com.dkatalis.parkinglot.model.Vehicle;
import com.dkatalis.parkinglot.util.constant.ApplicationConstants;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Optional;

/**
 * Created by Abhilash Kale on 11-04-2020.
 */
public class ParkingLotService {

  private ParkingLot parkingLot;

  public void createParkingSlot(int numberOfSlots) {
    parkingLot = new ParkingLot(numberOfSlots);
  }

  public void parkVehicle(Vehicle vehicle) {
    if (isParkingLotNotCreated()) {
      System.out.println("Sorry, parking lot is not created");
    } else if (isParkingLotFull()) {
      System.out.println("Sorry, parking lot is full");
    } else {
      parkVehicleIfParkingLotCreatedAndNotFull(vehicle);
    }
  }

  private boolean isParkingLotNotCreated() {
    return Objects.isNull(parkingLot);
  }

  private void parkVehicleIfParkingLotCreatedAndNotFull(Vehicle vehicle) {
    int slotNumber = parkingLot.getAvailableSlotQueue().poll();
    parkingLot.getSlotVehicleMap().put(slotNumber, vehicle);
    System.out.println("Allocated slot number: " + slotNumber);
  }

  private boolean isParkingLotFull() {
    return parkingLot.getSlotVehicleMap().size() == parkingLot.getNumberOfParkingSlots();
  }

  private boolean isParkingSlotsEmpty() {
    return parkingLot.getNumberOfParkingSlots() == ApplicationConstants.ZERO;
  }

  public ParkingSpot leaveSlot(String registrationNumber) {
    throwEmptyParkingLotExceptionIfEmpty();
    int slotNumber = getSlotNumber(registrationNumber);
    ParkingSpot parkingSpot;
    if (slotNumber != ApplicationConstants.MINUS_ONE) {
      parkingSpot = getParkingSpotAndUpdateSlotVehicleMap(slotNumber);
    } else {
      throw new VehicleNotFoundException("No vehicle found for the given registration number");
    }
    return parkingSpot;
  }

  private ParkingSpot getParkingSpotAndUpdateSlotVehicleMap(int slotNumber) {
    ParkingSpot parkingSpot;
    parkingSpot = new ParkingSpot(slotNumber, this.parkingLot.getSlotVehicleMap().get(slotNumber));
    this.parkingLot.getAvailableSlotQueue().add(slotNumber);
    this.parkingLot.getSlotVehicleMap().remove(slotNumber);
    return parkingSpot;
  }

  private void throwEmptyParkingLotExceptionIfEmpty() {
    if (isParkingSlotsEmpty()) {
      throwEmptyParkingLotException();
    }
  }

  private void throwEmptyParkingLotException() {
    throw new EmptyParkingLotException("Parking lot is empty");
  }

  private int getSlotNumber(String registrationNumber) {
    Map<Integer, Vehicle> slotVehicleMap = this.parkingLot.getSlotVehicleMap();
    int slotNumber = ApplicationConstants.MINUS_ONE;
    Optional<Integer> slotNumberOptional = getSlotNumberOptional(registrationNumber, slotVehicleMap);
    if (slotNumberOptional.isPresent()) {
      slotNumber = slotNumberOptional.get();
    }
    return slotNumber;
  }

  private Optional<Integer> getSlotNumberOptional(String registrationNumber, Map<Integer, Vehicle> slotVehicleMap) {
    if (slotVehicleMap.isEmpty()) {
      throwEmptyParkingLotException();
    }
    return slotVehicleMap.entrySet().stream()
        .filter(mapEntry -> registrationNumber.equals(mapEntry.getValue().getRegistrationNumber()))
        .map(Entry::getKey).findFirst();
  }

  public void validateParkingLotDetailsAndDisplayStatus() {
    if (isParkingSlotsOrSlotVehicleMapEmpty()) {
      throwEmptyParkingLotException();
    }
    displayStatus();
  }

  private void displayStatus() {
    System.out.println("Slot No.    Registration No.");
    Map<Integer, Vehicle> slotVehicleMap = parkingLot.getSlotVehicleMap();
    slotVehicleMap.forEach((key, value) -> System.out.println(key + "           " + value.getRegistrationNumber()));
  }

  private boolean isParkingSlotsOrSlotVehicleMapEmpty() {
    return isParkingSlotsEmpty() || parkingLot.getSlotVehicleMap().isEmpty();
  }
}
