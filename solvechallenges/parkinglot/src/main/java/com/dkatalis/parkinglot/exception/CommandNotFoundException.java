package com.dkatalis.parkinglot.exception;

/**
 * Created by Abhilash Kale on 11-04-2020.
 */
public class CommandNotFoundException extends InputCommandProcessException {

  public CommandNotFoundException(String message) {
    super(message);
  }
}
