package com.mm.marketmanager.api.models.requests;

import lombok.*;

import java.io.Serializable;
import java.util.List;

/**
 * Request model representing a sale in the market manager application.
 * Includes fields for branch ID and a list of sales details.
 *
 * @author caito
 *
 */
@NoArgsConstructor@AllArgsConstructor
@Getter@Setter@Builder
public class SalesRequest implements Serializable {
    private Long idBranch;
    private List<SalesDetailRequest> details;
}
