package com.hampcode.membershipmanagement.exception;

public class VisitLimitExceededException extends RuntimeException {
    public VisitLimitExceededException(String message) {
        super(message);
    }
}
