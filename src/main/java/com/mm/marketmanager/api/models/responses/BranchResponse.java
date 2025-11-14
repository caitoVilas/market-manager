package com.mm.marketmanager.api.models.responses;

import lombok.*;

import java.io.Serializable;

/**
 * Response model for Branch data in the Market Manager application.
 * Includes fields for id, name, address, cuit, phone, and email.
 *
 * @author caito
 *
 */
@NoArgsConstructor@AllArgsConstructor
@Getter@Setter@Builder
public class BranchResponse implements Serializable {
    private Long id;
    private String name;
    private String address;
    private String cuit;
    private String phone;
    private String email;
}
