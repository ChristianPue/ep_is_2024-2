package com.hampcode.membershipmanagement.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hampcode.membershipmanagement.dto.request.RegisterMembershipRequest;
import com.hampcode.membershipmanagement.dto.response.RegisterMembershipResponse;
import com.hampcode.membershipmanagement.service.MembershipService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/memberships")
@RequiredArgsConstructor
public class MembershipController {
  private final MembershipService service;

  @PostMapping
  public ResponseEntity<RegisterMembershipResponse> registerMembership(@Valid @RequestBody RegisterMembershipRequest request) {
      return new ResponseEntity<>(service.registerMembership(request), HttpStatus.CREATED);
  }
  

}
