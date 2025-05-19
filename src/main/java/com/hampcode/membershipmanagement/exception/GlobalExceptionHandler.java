package com.hampcode.membershipmanagement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MembershipAlreadyExistsException.class)
    public ResponseEntity<CustomErrorDetails> handleMembershipAlreadyExistsException(MembershipAlreadyExistsException ex) {
        CustomErrorDetails errorDetails = new CustomErrorDetails(
                LocalDateTime.now(),
                "Ya existe una membresía con el mismo nombre y tipo.",
                "Error: Membresía duplicada"
        );
        return new ResponseEntity<>(errorDetails, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(VisitLimitExceededException.class)
    public ResponseEntity<CustomErrorDetails> handleVisitLimitExceededException(VisitLimitExceededException ex) {
        CustomErrorDetails errorDetails = new CustomErrorDetails(
                LocalDateTime.now(),
                ex.getMessage(),
                "Error: Límite de visitas mensuales excedido."
        );
        return new ResponseEntity<>(errorDetails, HttpStatus.FORBIDDEN);
    }


    @ExceptionHandler(MembershipNotFoundException.class)
    public ResponseEntity<CustomErrorDetails> handleMembershipNotFoundException(MembershipNotFoundException ex) {
        CustomErrorDetails errorDetails = new CustomErrorDetails(
                LocalDateTime.now(),
                "No se encontró la membresía solicitada.",
                "Membresía no encontrada"
        );
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<CustomErrorDetails> handleGlobalException(Exception ex) {
        CustomErrorDetails errorDetails = new CustomErrorDetails(
                LocalDateTime.now(),
                "Ocurrió un error inesperado en el servidor.",
                "Error interno del servidor"
        );
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
