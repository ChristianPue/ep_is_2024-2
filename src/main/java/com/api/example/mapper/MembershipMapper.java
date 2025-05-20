package com.api.example.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.api.example.dto.request.RegisterMembershipRequest;
import com.api.example.dto.response.MembershipResponse;
import com.api.example.model.entity.Membership;
import com.api.example.model.enums.MembershipType;

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
  public MembershipResponse toMembershipResponse(Membership membership){
    if (membership == null) { return null; }

    return new MembershipResponse(
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

  // Convertir "List<Membership>" a "List<MembershipResponse>"
  public List<MembershipResponse> toMembershipsResponse(List<Membership> list) {
    if (list == null) { return null; }

    return list.stream().map(this::toMembershipResponse).collect(Collectors.toList());
  }
}
