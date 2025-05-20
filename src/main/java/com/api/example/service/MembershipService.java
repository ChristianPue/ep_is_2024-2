package com.api.example.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.api.example.dto.request.RegisterMembershipRequest;
import com.api.example.dto.response.MembershipResponse;
import com.api.example.dto.response.StadisticReportResponse;
import com.api.example.exception.DuplicatedMembershipException;
import com.api.example.exception.ResourceNotFoundException;
import com.api.example.exception.VisitLimitExceededException;
import com.api.example.mapper.MembershipMapper;
import com.api.example.model.entity.Membership;
import com.api.example.model.enums.MembershipType;
import com.api.example.repository.MembershipRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MembershipService {
  private final MembershipRepository repository;
  private final MembershipMapper mapper;

  // Registrar una nueva membresía
  @Transactional
  public MembershipResponse registerMembership(RegisterMembershipRequest request){
    Membership membership = mapper.toMembership(request);

    if (repository.existsByMemberNameAndMembershipType(membership.getMemberName(), membership.getMembershipType())){
      throw new DuplicatedMembershipException("Ya existe una membresía con el mismo nombre y tipo de miembro.");
    }

    repository.save(membership);
    
    return mapper.toMembershipResponse(membership);
  }

  // Registrar la visita de un miembro según su id
  @Transactional
  public MembershipResponse registerMembershipVisit(Long id) {
    Membership membership = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No se encontró dicho miembro de usuario."));
    
    for (MembershipType type : MembershipType.values()) {
      switch (type) {
        case BASICA:
          if (membership.getMonthlyVisits() == 10) {
            throw new VisitLimitExceededException("Has alcanzado el límite de 10 visitas mensuales para la membresía Básica.");
          }
          break;
        case PREMIUM:
          if (membership.getMonthlyVisits() == 20) {
            throw new VisitLimitExceededException("Has alcanzado el límite de 20 visitas mensuales para la membresía Premium.");
          }
          break;
        case VIP:
          // Es ilimitado
          break;
      }
    }

    membership.setMonthlyVisits(membership.getMonthlyVisits() + 1);

    repository.save(membership);

    return mapper.toMembershipResponse(membership);
  }

  // Listar membresías por tipo de membresía
  @Transactional
  public List<MembershipResponse> getListMembershipByMembershipType(String filter) {
    MembershipType type = MembershipType.valueOf(filter);

    List<Membership> list = repository.findByMembershipsType(type);

    return mapper.toMembershipsResponse(list);
  }

  // Generar reporte de estadísticas
  @Transactional
  public List<StadisticReportResponse> statisticsReportByMembershipType() {
    List<StadisticReportResponse> list = new ArrayList<>();

    for (MembershipType type : MembershipType.values()) {

      List<Membership> listByMemberType = repository.findByMembershipsType(type);

      // Validar que la lista no sea nula
      if (listByMemberType == null) {
        listByMemberType = new ArrayList<>(); // Evita NullPointerException
      }

      int totalMonthlyVisits = 0;
      for (Membership membership : listByMemberType) {
        totalMonthlyVisits += membership.getMonthlyVisits();
      }

      StadisticReportResponse response = new StadisticReportResponse(
        type, // membershipType
        listByMemberType.size(), //totalMembers
        totalMonthlyVisits // totalMonthlyVisits
      );

      list.add(response);
    }

    return list;
  }

  // Eliminar una membresía
  @Transactional
  public String deleteMembership(Long id) {
    Membership membership = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No se encontró la membresía con ID " + id + "."));
    repository.delete(membership);
    return "Se eliminó la cuenta satisfactoriamente.";
  }
}