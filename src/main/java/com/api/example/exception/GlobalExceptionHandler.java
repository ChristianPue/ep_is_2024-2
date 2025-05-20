package com.api.example.exception;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
  @ExceptionHandler(DuplicatedMembershipException.class)
  public Map<String, Object> handleDuplicatedMembershipException(DuplicatedMembershipException ex) {
    Map<String, Object> errorResponse = new LinkedHashMap<>();
    errorResponse.put("timestamp", LocalDateTime.now()); // Marca de tiempo automática
    errorResponse.put("message", ex.getMessage());
    errorResponse.put("details", "DuplicatedMembershipException");
    return errorResponse;
  }

  @ExceptionHandler(ResourceNotFoundException.class)
  public Map<String, Object> handleResourceNotFoundException(ResourceNotFoundException ex) {
    Map<String, Object> errorResponse = new LinkedHashMap<>();
    errorResponse.put("timestamp", LocalDateTime.now()); // Marca de tiempo automática
    errorResponse.put("message", ex.getMessage());
    errorResponse.put("details", "ResourceNotFoundException");
    return errorResponse;
  }

  @ExceptionHandler(VisitLimitExceededException.class)
  public Map<String, Object> handlerVisitLimitExceededException(VisitLimitExceededException ex) {
    Map<String, Object> errorResponse = new LinkedHashMap<>();
    errorResponse.put("timestamp", LocalDateTime.now()); // Marca de tiempo automática
    errorResponse.put("message", ex.getMessage());
    errorResponse.put("details", "VisitLimitExceededException");
    return errorResponse;
  }
}
