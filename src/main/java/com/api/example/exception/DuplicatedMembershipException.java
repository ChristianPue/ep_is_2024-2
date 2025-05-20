package com.api.example.exception;

public class DuplicatedMembershipException extends RuntimeException {
  public DuplicatedMembershipException(String message) {
    super(message);
  }
}
