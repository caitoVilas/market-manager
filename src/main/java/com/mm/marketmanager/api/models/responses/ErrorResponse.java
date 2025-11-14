package com.mm.marketmanager.api.models.responses;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * ErrorResponse is a model class that represents the structure of an error response.
 *
 * @author Caito
 */
@NoArgsConstructor@AllArgsConstructor
@Getter@Setter@Builder
public class ErrorResponse implements Serializable {
    private int code;
    private String status;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime timestamp;
    private String message;
    private String method;
    private String path;
}
