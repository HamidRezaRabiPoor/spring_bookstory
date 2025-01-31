package org.example.exeptions;

public class DuplicateRecordException extends RuntimeException {
  public DuplicateRecordException(String message) {
    super(message);
  }
}
