package com.mm.marketmanager.api.controllers.impl;

import com.mm.marketmanager.api.controllers.contracts.BranchController;
import com.mm.marketmanager.api.models.requests.BranchRequest;
import com.mm.marketmanager.api.models.responses.BranchResponse;
import com.mm.marketmanager.services.contracts.BranchService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Implementation of the BranchController interface for managing branches
 * in the Market Manager application.
 *
 * Provides endpoints for adding, retrieving, updating, and deleting branches.
 *
 * @author caito
 *
 */
@RestController
@RequestMapping("/v1/branches")
@RequiredArgsConstructor
@Tag(name = "Branch API", description = "APIs for managing branches")
public class BranchControllerImpl implements BranchController {
    private final BranchService branchService;

    @Override
    public ResponseEntity<?> addBranch(BranchRequest request) {
        branchService.addBranch(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Override
    public ResponseEntity<List<BranchResponse>> getAllBranches() {
        var branches = branchService.getAllBranches();
        if (branches.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(branches);
    }

    @Override
    public ResponseEntity<BranchResponse> getBranch(Long id) {
        return ResponseEntity.ok(branchService.getBranchById(id));
    }

    @Override
    public ResponseEntity<BranchResponse> updateBranch(Long id, BranchRequest request) {
        return ResponseEntity.ok(branchService.updateBranch(id, request));
    }

    @Override
    public ResponseEntity<?> deleteBranch(Long id) {
        branchService.deleteBranch(id);
        return ResponseEntity.noContent().build();
    }
}
