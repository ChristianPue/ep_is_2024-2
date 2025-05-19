package com.hampcode.membershipmanagement.dto.response;

import com.hampcode.membershipmanagement.model.enums.MembershipType;

public record RegisterMembershipResponse(
  Long id,
  String memberName,
  MembershipType membershipType,
  int monthsSubscribed,
  int monthsRemaining,
  Double membershipPrice,
  int monthlyVisits,
  String description
){}