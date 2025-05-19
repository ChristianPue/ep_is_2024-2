package com.hampcode.membershipmanagement.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomErrorDetails {

    private LocalDateTime timestamp;
    private String message;
    private String details;

}
