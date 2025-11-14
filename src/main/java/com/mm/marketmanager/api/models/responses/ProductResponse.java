package com.mm.marketmanager.api.models.responses;

import lombok.*;

import java.io.Serializable;

/**
 * Response model for a product in the market manager application.
 * Includes fields for id, name, category, description, price, and stock.
 *
 * @author caito
 *
 */
@NoArgsConstructor@AllArgsConstructor
@Getter@Setter@Builder
public class ProductResponse implements Serializable {
    private Long id;
    private String name;
    private String category;
    private String description;
    private Double price;
    private Integer stock;
}
