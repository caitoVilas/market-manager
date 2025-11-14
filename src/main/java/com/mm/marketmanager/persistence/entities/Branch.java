package com.mm.marketmanager.persistence.entities;

import jakarta.persistence.*;
import lombok.*;

/**
 * Entity class representing a Branch in the Market Manager application.
 * Includes fields for id, name, address, cuit, phone, and email.
 *
 * @author caito
 *
 */
@Entity
@Table(name = "branches")
@NoArgsConstructor@AllArgsConstructor
@Getter@Setter@Builder
public class Branch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;
    @Column(unique = true)
    private String cuit;
    private String phone;
    @Column(unique = true)
    private String email;
}
