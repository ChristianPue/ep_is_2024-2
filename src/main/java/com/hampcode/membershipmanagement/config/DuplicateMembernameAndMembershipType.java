package com.hampcode.membershipmanagement.config;

public class DuplicateMembernameAndMembershipType extends RuntimeException {
  public DuplicateMembernameAndMembershipType(String message) {
    super(message);
  }
}
