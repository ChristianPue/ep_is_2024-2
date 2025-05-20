package com.api.example.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;

public record RegisterMembershipRequest(
  @NotBlank(message = "El nombre del miembro no puede ser vacío.")
  String memberName,
  
  @NotBlank(message = "El tipo del miembro no puede ser vacío.")
  @Pattern(regexp = "^(BASICA|PREMIUM|VIP)$", message = "El tipo de miembre puede ser BASICA, PREMIUM o VIP.")
  String membershipType,

  @NotNull(message = "La cantidad de meses no puede ser nula.")
  @Min(value = 1, message = "La cantidad de meses mínima es 1.")
  int monthsSubscribed,

  @NotNull(message = "El precio de la membresía no puede ser nula.")
  @Positive(message = "El precio de la membersía debe ser mayor a 0.")
  Double membershipPrice,

  @NotBlank(message = "La descripción no puede ser vacía.")
  String description
) {}
