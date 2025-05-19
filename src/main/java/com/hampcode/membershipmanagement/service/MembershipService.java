package com.hampcode.membershipmanagement.service;

import org.springframework.stereotype.Service;

import com.hampcode.membershipmanagement.config.DuplicateMembernameAndMembershipType;
import com.hampcode.membershipmanagement.dto.request.RegisterMembershipRequest;
import com.hampcode.membershipmanagement.dto.response.RegisterMembershipResponse;
import com.hampcode.membershipmanagement.mapper.MembershipMapper;
import com.hampcode.membershipmanagement.model.entity.Membership;
import com.hampcode.membershipmanagement.repository.MembershipRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MembershipService {
  private final MembershipRepository repository;
  private final MembershipMapper mapper;

  // Registrar una nueva membresía
  @Transactional
  public RegisterMembershipResponse registerMembership(RegisterMembershipRequest request){
    Membership membership = mapper.toMembership(request);

    if (repository.existsByMemberNameAndMembershipType(membership.getMemberName(), membership.getMembershipType())){
      throw new DuplicateMembernameAndMembershipType("Ya existe una membresía con el mismo nombre y tipo de miembro.");
    }

    repository.save(membership);
    
    return mapper.toRegisterMembershipResponse(membership);
  }
}
