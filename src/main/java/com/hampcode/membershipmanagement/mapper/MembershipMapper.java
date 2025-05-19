package com.hampcode.membershipmanagement.mapper;

import org.springframework.stereotype.Component;

import com.hampcode.membershipmanagement.dto.request.RegisterMembershipRequest;
import com.hampcode.membershipmanagement.dto.response.RegisterMembershipResponse;
import com.hampcode.membershipmanagement.model.entity.Membership;
import com.hampcode.membershipmanagement.model.enums.MembershipType;

@Component
public class MembershipMapper {
  // Convertir "RegisterMembershipRequest" a "Membership"
  public Membership toMembership(RegisterMembershipRequest request) {
    if (request == null) { return null; }

    Membership membership = Membership.builder()
      .memberName(request.memberName())
      .membershipType(MembershipType.valueOf(request.membershipType()))
      .monthsSubscribed(request.monthsSubscribed())
      .monthsRemaining(request.monthsSubscribed())
      .membershipPrice(request.membershipPrice())
      .monthlyVisits(0)
      .description(request.description())
      .build();

    return membership;
  }

  // Convertir "Membership" a "MembershipResponse"
  public RegisterMembershipResponse toRegisterMembershipResponse(Membership membership){
    if (membership == null) { return null; }

    return new RegisterMembershipResponse(
      membership.getId(),
      membership.getMemberName(),
      membership.getMembershipType(),
      membership.getMonthsSubscribed(),
      membership.getMonthsRemaining(),
      membership.getMembershipPrice(),
      membership.getMonthlyVisits(),
      membership.getDescription()
    );
  }
}
