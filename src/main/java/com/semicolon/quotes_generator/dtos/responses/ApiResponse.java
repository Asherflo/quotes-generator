package com.semicolon.quotes_generator.dtos.responses;


import lombok.*;

@Builder
@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor
public class ApiResponse {
    private String message;
    private Object data;
    private String status;
    private int result;
}
