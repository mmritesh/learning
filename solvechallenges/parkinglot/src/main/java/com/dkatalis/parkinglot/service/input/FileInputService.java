package com.dkatalis.parkinglot.service.input;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Abhilash Kale on 11-04-2020.
 */
public class FileInputService extends UserInputService {

  String filePath;

  public FileInputService(String filePath) {
    this.filePath = filePath;
  }

  public void processUserInput() {
    File inputFile = new File(filePath);
    try (BufferedReader bufferedReader = getCurrentFileReader(inputFile)) {
      readAndProcessLines(bufferedReader);
    } catch (Exception exception) {
      logExceptionForFileReadOperation();
    }
  }

  private void logExceptionForFileReadOperation() {
    System.out.println("Exception occurred while reading file contents. Please try again");
  }

  private void readAndProcessLines(BufferedReader bufferedReader) throws IOException {
    String line;
    while ((line = bufferedReader.readLine()) != null) {
      validateAndProcess(line);
    }
  }

  private BufferedReader getCurrentFileReader(File inputFile) throws FileNotFoundException {
    return new BufferedReader(new FileReader(inputFile));
  }
}
