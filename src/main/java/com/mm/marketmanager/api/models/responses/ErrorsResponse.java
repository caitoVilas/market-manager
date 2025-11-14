package com.mm.marketmanager.api.models.responses;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * ErrorsResponse is a model class that represents the structure of an error response
 * containing multiple error messages.
 *
 * @author Caito
 */
@NoArgsConstructor@AllArgsConstructor
@Getter@Setter@Builder
public class ErrorsResponse implements Serializable {
    private int code;
    private String status;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime timestamp;
    private List<String> messages;
    private String method;
    private String path;
}
