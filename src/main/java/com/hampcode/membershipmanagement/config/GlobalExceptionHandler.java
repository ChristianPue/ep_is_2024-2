package com.hampcode.membershipmanagement.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice("exceptionHandlerAdvice")
public class GlobalExceptionHandler {
  @ExceptionHandler(DuplicateMembernameAndMembershipType.class)
  public ProblemDetail handleDuplicateMembernameAndMembershipType(DuplicateMembernameAndMembershipType ex){
    ProblemDetail problem = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, ex.getMessage());
    problem.setTitle("Nombre del miembro y el tipo de miembro duplicados.");
    return problem;
  }
}
