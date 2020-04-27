package com.dkatalis.parkinglot.model;

import com.dkatalis.parkinglot.util.constant.VehicleSize;
import lombok.Data;

/**
 * Created by Abhilash Kale on 11-04-2020.
 */
@Data
public abstract class Vehicle {

  protected String registrationNumber;
  protected int spotsNeeded;
  protected VehicleSize size;
}
