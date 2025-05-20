package com.api.example.model.entity;

import com.api.example.model.enums.MembershipType;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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

  @Enumerated(EnumType.STRING)
  private MembershipType membershipType;

  private int monthsSubscribed;

  private int monthsRemaining;
  
  private Double membershipPrice;

  private int monthlyVisits;

  private String description;
}