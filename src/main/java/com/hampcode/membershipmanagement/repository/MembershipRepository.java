package com.hampcode.membershipmanagement.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hampcode.membershipmanagement.model.entity.Membership;
import com.hampcode.membershipmanagement.model.enums.MembershipType;

public interface MembershipRepository extends JpaRepository<Membership, Long> {
  // Verifica si existe un Membership con un MemberName específico
  @Query("SELECT CASE WHEN COUNT(m) > 0 THEN true ELSE false END FROM Membership m WHERE m.memberName =:memberName")
  boolean existsByMemberName(@Param("memberName") String memberName);
  // Busca un Membership por un MemberName en específico
  @Query("SELECT m FROM Membership m WHERE m.MemberName =:memberName")
  Optional<Membership> findByMemberName(@Param("memberName") String memberName);
  
  // Verifica si existe un Membership por un MemberName y MembershipType en específico
  @Query("SELECT CASE WHEN COUNT(m) > 0 THEN true ELSE false END FROM Membership m WHERE m.memberName =:memberName AND m.membershipType =: membershipType")
  boolean existsByMemberNameAndMembershipType(@Param("memberName") String memberName, @Param("membershipType") MembershipType membershipType);

  // Busca uno o mas Membership con un MembershipType en específico
  @Query("SELECT m FROM Membership m WHERE m.membershipType =:membershipType")
  List<Membership> findByMembershipsType(@Param("membershipType") MembershipType membershipType);
}
