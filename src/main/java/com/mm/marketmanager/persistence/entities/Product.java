package com.mm.marketmanager.persistence.entities;

import jakarta.persistence.*;
import lombok.*;

/**
 * Entity class representing a product in the market manager application.
 * Includes fields for id, name, category, description, price, and stock.
 *
 * @author caito
 *
 */
@Entity
@Table(name = "products")
@NoArgsConstructor@AllArgsConstructor
@Getter@Setter@Builder
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String category;
    private String description;
    private Double price;
    private Integer stock;
}
