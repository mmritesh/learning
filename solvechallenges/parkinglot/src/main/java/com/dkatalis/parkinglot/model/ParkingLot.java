package com.dkatalis.parkinglot.model;

import com.dkatalis.parkinglot.exception.EmptyParkingLotException;
import com.dkatalis.parkinglot.util.constant.ApplicationConstants;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;
import java.util.stream.IntStream;
import lombok.Data;

/**
 * Created by Abhilash Kale on 11-04-2020.
 */
@Data
public class ParkingLot {

  private int numberOfParkingSlots;
  private Queue<Integer> availableSlotQueue;
  private Map<Integer, Vehicle> slotVehicleMap;

  public ParkingLot(int numberOfParkingSlots) {
    checkIfEmptyParkingLotAndThrowException(numberOfParkingSlots);
    this.numberOfParkingSlots = numberOfParkingSlots;
    initializeInstanceVariables();
  }

  private void initializeInstanceVariables() {
    this.slotVehicleMap = new TreeMap<>();
    createInitialAvailableSlotList();
  }

  private void checkIfEmptyParkingLotAndThrowException(int numberOfParkingSlots) {
    if (isNumberOfSlotsEmpty(numberOfParkingSlots)) {
      throw new EmptyParkingLotException("Parking lot size cannot be zero");
    }
  }

  private boolean isNumberOfSlotsEmpty(int numberOfParkingSlots) {
    return numberOfParkingSlots == ApplicationConstants.ZERO;
  }

  private void createInitialAvailableSlotList() {
    availableSlotQueue = new LinkedList<>();
    IntStream.rangeClosed(1, numberOfParkingSlots).forEach(i -> availableSlotQueue.add(i));
  }
}
