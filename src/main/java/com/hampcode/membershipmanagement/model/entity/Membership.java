package com.hampcode.membershipmanagement.model.entity;

import jakarta.persistence.Entity;

import com.hampcode.membershipmanagement.model.enums.MembershipType;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "memberships")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Membership {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String memberName;
  
  private MembershipType membershipType;

  private int monthsSubscribed;

  private int monthsRemaining;

  @Enumerated(EnumType.STRING)
  private Double membershipPrice;

  private int monthlyVisits;

  private String description;
}
