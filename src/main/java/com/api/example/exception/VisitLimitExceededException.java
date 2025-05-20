package com.api.example.exception;

public class VisitLimitExceededException extends RuntimeException {
  public VisitLimitExceededException(String message) {
    super(message);
  }
}
