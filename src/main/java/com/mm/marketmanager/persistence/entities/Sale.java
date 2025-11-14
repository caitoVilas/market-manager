package com.mm.marketmanager.persistence.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

/**
 * Entity class representing a sale in the market manager application.
 * Includes fields for id, date, status, and associated branch.
 *
 * @author caito
 *
 */
@Entity
@Table(name = "sales")
@NoArgsConstructor@AllArgsConstructor
@Setter@Getter@Builder
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate date;
    private String status;
    private Double total;
    @ManyToOne(fetch = FetchType.LAZY)
    private Branch branch;
}
