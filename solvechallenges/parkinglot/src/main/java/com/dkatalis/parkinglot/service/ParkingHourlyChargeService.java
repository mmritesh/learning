package com.dkatalis.parkinglot.service;

import com.dkatalis.parkinglot.exception.InvalidParkingDurationException;
import com.dkatalis.parkinglot.util.constant.ApplicationConstants;

/**
 * Created by Abhilash Kale on 11-04-2020.
 */
public class ParkingHourlyChargeService implements ParkingChargeService {

  @Override
  public long getCharge(int numberOfHours) {
    if (numberOfHours <= ApplicationConstants.ZERO) {
      throw new InvalidParkingDurationException(
          "Invalid parking duration provided. Hour cannot be zero or less then zero");
    }
    int totalCharge = 10;
    if (numberOfHours > 2) {
      totalCharge += ((numberOfHours - 2) * 10);
    }
    return totalCharge;
  }
}
