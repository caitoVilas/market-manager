package com.mm.marketmanager.api.models.responses;

import lombok.*;

import java.io.Serializable;

/**
 * Response model representing the details of a sale in the market manager application.
 * Includes fields for id, product name, product description, quantity, and price.
 *
 * @author caito
 *
 */
@NoArgsConstructor@AllArgsConstructor
@Getter@Setter@Builder
public class SalesDetailResponse implements Serializable {
    private Long id;
    private String productName;
    private String productDescription;
    private Integer quantity;
    private Double price;
}
