package com.mm.marketmanager.services.contracts;

import com.mm.marketmanager.api.models.requests.BranchRequest;
import com.mm.marketmanager.api.models.responses.BranchResponse;

import java.util.List;

/**
 * Service contract for managing branches in the Market Manager application.
 * Provides methods for adding, retrieving, updating, and deleting branches.
 *
 * @author caito
 *
 */
public interface BranchService {
    void addBranch(BranchRequest request);
    BranchResponse getBranchById(Long id);
    List<BranchResponse> getAllBranches();
    BranchResponse updateBranch(Long id, BranchRequest request);
    void deleteBranch(Long id);
}
