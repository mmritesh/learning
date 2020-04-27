package com.dkatalis.parkinglot.model;

import com.dkatalis.parkinglot.util.constant.VehicleSize;
import lombok.Data;

/**
 * Created by Abhilash Kale on 11-04-2020.
 */
@Data
public class Car extends Vehicle {

  public Car() {
    spotsNeeded = 1;
    size = VehicleSize.SMALL;
  }
}
