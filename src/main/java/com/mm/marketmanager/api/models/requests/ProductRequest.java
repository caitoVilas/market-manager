package com.mm.marketmanager.api.models.requests;

import lombok.*;

import java.io.Serializable;

/**
 * Request model for creating or updating a product in the market manager application.
 * Includes fields for name, category, description, price, and stock.
 *
 * @author caito
 *
 */
@NoArgsConstructor@AllArgsConstructor
@Getter@Setter@Builder
public class ProductRequest implements Serializable {
    private String name;
    private String category;
    private String description;
    private Double price;
    private Integer stock;
}
