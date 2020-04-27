package com.dkatalis.parkinglot.model;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by Abhilash Kale on 11-04-2020.
 */
@Getter
@Setter
public class ParkingSpot {

  private int slotNumber;
  private Vehicle vehicle;

  public ParkingSpot(int slotNumber, Vehicle vehicle) {
    this.slotNumber = slotNumber;
    this.vehicle = vehicle;
  }
}
