package com.mm.marketmanager.persistence.entities;

import jakarta.persistence.*;
import lombok.*;

/**
 * Entity class representing the details of a sale in the market manager application.
 * Includes fields for id, associated sale, product, quantity, and price.
 *
 * @author caito
 *
 */
@Entity
@Table(name = "sales_details")
@NoArgsConstructor@AllArgsConstructor
@Getter@Setter@Builder
public class SalesDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Sale sale;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Product product;
    private Integer quantity;
    private Double price;
}
