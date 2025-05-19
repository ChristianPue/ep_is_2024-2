package com.hampcode.membershipmanagement.exception;

public class MembershipAlreadyExistsException extends RuntimeException {
    public MembershipAlreadyExistsException(String message) {
        super(message);
    }
}
