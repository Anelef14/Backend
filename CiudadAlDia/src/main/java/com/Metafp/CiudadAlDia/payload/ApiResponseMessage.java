package com.Metafp.CiudadAlDia.payload;

import lombok.*;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApiResponseMessage {
    private String message;
    private HttpStatus status;
    private boolean success;
    private Object data;
}
