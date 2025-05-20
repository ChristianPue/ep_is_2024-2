package com.api.example.dto.response;

import com.api.example.model.enums.MembershipType;

public record MembershipResponse(
  Long id,
  String memberName,
  MembershipType membershipType,
  int monthsSubscribed,
  int monthsRemaining,
  Double membershipPrice,
  int monthlyVisits,
  String description
) {}
