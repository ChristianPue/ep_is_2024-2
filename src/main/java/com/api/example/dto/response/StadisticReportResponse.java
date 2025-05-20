package com.api.example.dto.response;

import com.api.example.model.enums.MembershipType;

public record StadisticReportResponse(
  MembershipType membershipType,
  int totalMembers,
  int totalMonthlyVisits
) {}
