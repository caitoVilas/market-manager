package com.mm.marketmanager.utils.mappers;

import com.mm.marketmanager.api.models.requests.BranchRequest;
import com.mm.marketmanager.api.models.responses.BranchResponse;
import com.mm.marketmanager.persistence.entities.Branch;

/**
 * Utility class for mapping between BranchRequest, BranchResponse, and Branch entity.
 *
 * @author caito
 *
 */
public class BranchMapper {

    /**
     * Maps a BranchRequest to a Branch entity.
     *
     * @param request the BranchRequest object
     * @return the mapped Branch entity
     */
    public static Branch mapToEntity(BranchRequest request){
        return Branch.builder()
                .name(request.getName())
                .address(request.getAddress())
                .cuit(request.getCuit())
                .phone(request.getPhone())
                .email(request.getEmail())
                .build();
    }

    /**
     * Maps a Branch entity to a BranchResponse.
     *
     * @param branch the Branch entity
     * @return the mapped BranchResponse object
     */
    public static BranchResponse mapToDto(Branch branch){
        return BranchResponse.builder()
                .id(branch.getId())
                .name(branch.getName())
                .address(branch.getAddress())
                .cuit(branch.getCuit())
                .phone(branch.getPhone())
                .email(branch.getEmail())
                .build();
    }
}
