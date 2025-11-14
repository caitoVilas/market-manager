package com.mm.marketmanager.api.models.responses;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.io.Serializable;
import java.util.List;
import java.util.Locale;

/**
 * Response model representing a sale in the market manager application.
 * Includes fields for id, branch ID, a list of sales details, and total amount.
 *
 * @author caito
 *
 */
@NoArgsConstructor@AllArgsConstructor
@Getter@Setter@Builder
public class SalesResponse implements Serializable {
    private Long id;
    private Long branchId;
    @JsonFormat(shape = JsonFormat.Shape.STRING , pattern = "yyyy-MM-dd")
    private Locale date;
    private String status;
    private List<SalesDetailResponse> details;
    private Double total;
}
