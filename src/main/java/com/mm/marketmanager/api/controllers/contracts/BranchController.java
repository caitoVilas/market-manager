package com.mm.marketmanager.api.controllers.contracts;

import com.mm.marketmanager.api.models.requests.BranchRequest;
import com.mm.marketmanager.api.models.responses.BranchResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller contract for managing branches in the Market Manager application.
 * Provides endpoints for adding, retrieving, updating, and deleting branches.
 *
 * @author caito
 *
 */
public interface BranchController {
    @PostMapping()
    @Operation(description = "Add a new Branch")
    @Parameter(name = "request", description = "Branch request object containing details of the branch to be added")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Branch added successfully"),
            @ApiResponse(responseCode = "400", description = "Bad request, invalid input data"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<?> addBranch(@RequestBody BranchRequest request);

    @GetMapping
    @SecurityRequirement(name = "security token")
    @Operation(description = "Retrieve all Branches")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Branch retrieved successfully"),
            @ApiResponse(responseCode = "204", description = "No content"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<List<BranchResponse>> getAllBranches();

    @GetMapping("/{id}")
    @SecurityRequirement(name = "security token")
    @Operation(description = "Retrieve Branch by ID")
    @Parameter(name = "id", description = "Id of Branch")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Branch retrieved successfully"),
            @ApiResponse(responseCode = "404", description = "Not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<BranchResponse> getBranch(@PathVariable Long id);

    @PutMapping("/update/{id}")
    @SecurityRequirement(name = "security token")
    @Operation(description = "Update an existing Branch")
    @Parameters({
            @Parameter(name = "id", description = "ID of the Branch to update"),
            @Parameter(name = "request", description = "fields of Branch")
    })
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Branch updated successfully"),
            @ApiResponse(responseCode = "404", description = "Not found"),
            @ApiResponse(responseCode = "400", description = "Bad request, invalid input data"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<BranchResponse> updateBranch(@PathVariable Long id, @RequestBody BranchRequest request);

    @DeleteMapping("/{id}")
    @SecurityRequirement(name = "security token")
    @Operation(description = "Delete an existing Branch")
    @Parameter(name = "id", description = "ID of the Branch to delete")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Branch deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<?> deleteBranch(@PathVariable Long id);
}
