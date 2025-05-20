package com.api.example.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.example.dto.request.RegisterMembershipRequest;
import com.api.example.dto.response.MembershipResponse;
import com.api.example.dto.response.StadisticReportResponse;
import com.api.example.service.MembershipService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/memberships")
@RequiredArgsConstructor
public class MembershipController {
  private final MembershipService service;

  @PostMapping
  public ResponseEntity<MembershipResponse> registerMembership(@Valid @RequestBody RegisterMembershipRequest request) {
    return new ResponseEntity<>(service.registerMembership(request), HttpStatus.CREATED);
  }

  @PutMapping("/{id}/visit")
  public ResponseEntity<MembershipResponse> registerMembershipVisit(@PathVariable Long id) {
    return new ResponseEntity<>(service.registerMembershipVisit(id), HttpStatus.ACCEPTED);
  }

  // En Postman: "?membershipType=BASICA"
  // Params: Key | Value | Description
  //  membershipType | BASICA | ...
  @GetMapping
  public ResponseEntity<List<MembershipResponse>> getListMembershipByMembershipType(@RequestParam String membershipType) {
    return new ResponseEntity<>(service.getListMembershipByMembershipType(membershipType), HttpStatus.OK);
  }
  // Para dos o más parámetros agregar "&"
  // Postman: "/filter?membershipType=VIP&minVisits=5&maxVisits=20"
  // Params: Key | Value | Description
  //  membershipType | VIP | ...
  //  minVisits      | 5      | ...
  //  maxVisits      | 20     | ...
  // @GetMapping("/filter")
  // ...
  
  @GetMapping("/statistics")
  public ResponseEntity<List<StadisticReportResponse>> statisticsReportByMembershipType() {
    return new ResponseEntity<>(service.statisticsReportByMembershipType(), HttpStatus.OK);
  }
  
  @DeleteMapping("/{id}")
  public ResponseEntity<String> deleteMembership(@PathVariable Long id) {
    return new ResponseEntity<>(service.deleteMembership(id), HttpStatus.OK);
  }
}
