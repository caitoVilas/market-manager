package com.mm.marketmanager.api.models.requests;

import lombok.*;

import java.io.Serializable;

/**
 * Request model representing the details of a sale in the market manager application.
 * Includes fields for sale ID, product ID, quantity, and price.
 *
 * @author caito
 *
 */
@NoArgsConstructor@AllArgsConstructor
@Getter@Setter@Builder
public class SalesDetailRequest implements Serializable {
    private Long idSale;
    private Long idProduct;
    private Integer quantity;
    private Double price;
}
