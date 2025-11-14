package com.mm.marketmanager.api.models.requests;

import lombok.*;

import java.io.Serializable;

/**
 * Request model for creating or updating a Branch in the Market Manager application.
 * Includes fields for name, address, cuit, phone, and email.
 *
 * @author caito
 *
 */
@NoArgsConstructor@AllArgsConstructor
@Getter@Setter@Builder
public class BranchRequest implements Serializable {
    private String name;
    private String address;
    private String cuit;
    private String phone;
    private String email;
}
