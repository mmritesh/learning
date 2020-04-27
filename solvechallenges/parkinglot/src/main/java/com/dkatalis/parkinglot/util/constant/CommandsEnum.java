package com.dkatalis.parkinglot.util.constant;

import com.dkatalis.parkinglot.exception.CommandNotFoundException;

/**
 * Created by Abhilash Kale on 11-04-2020.
 */
public enum CommandsEnum {
  CREATE_PARKING_LOT("create_parking_lot"),
  PARK("park"),
  LEAVE("leave"),
  STATUS("status");
  private String value;

  CommandsEnum(String string) {
    value = string;
  }

  public String getValue() {
    return value;
  }

  public static CommandsEnum getCommand(String[] userInputArray) {
    String inputValue = userInputArray[ApplicationConstants.ZERO];
    for (CommandsEnum commandEnum : CommandsEnum.values()) {
      if (commandEnum.getValue().equals(inputValue)) {
        return commandEnum;
      }
    }
    throw new CommandNotFoundException("Command not found in provided input");
  }
}
