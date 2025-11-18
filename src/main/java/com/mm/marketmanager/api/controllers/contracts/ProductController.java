package com.mm.marketmanager.api.controllers.contracts;

import com.mm.marketmanager.api.models.requests.ProductRequest;
import com.mm.marketmanager.api.models.responses.ProductResponse;

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
 * Controller contract for managing products in the Market Manager application.
 * Provides endpoints for adding, retrieving, updating, and deleting products.
 *
 * @author caito
 *
 */
public interface ProductController {

    @PostMapping()
    @Operation(description = "Add a new Product")
    @Parameter(name = "request", description = "Product request object containing details of the product to be added")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Product added successfully"),
            @ApiResponse(responseCode = "400", description = "Bad request, invalid input data"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<?> addProduct(@RequestBody ProductRequest request);

    @GetMapping
    @SecurityRequirement(name = "security token")
    @Operation(description = "Retrieve all Products")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Products retrieved successfully"),
            @ApiResponse(responseCode = "204", description = "No content"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<List<ProductResponse>> getAllProducts();

    @GetMapping("/{id}")
    @SecurityRequirement(name = "security token")
    @Operation(description = "Retrieve Product by ID")
    @Parameter(name = "Id", description = "Id of Product")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Product retrieved successfully"),
            @ApiResponse(responseCode = "404", description = "Not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<ProductResponse> getProduct(@PathVariable Long id);

    @PutMapping("/update/{id}")
    @SecurityRequirement(name = "security token")
    @Operation(description = "Update an existing Product")
    @Parameters({
            @Parameter(name = "id", description = "ID of the user to update"),
            @Parameter(name = "request", description = "fields of Products")
    })
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Product updated successfully"),
            @ApiResponse(responseCode = "404", description = "Not found"),
            @ApiResponse(responseCode = "400", description = "Bad request, invalid input data"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<ProductResponse> updateProduct(@PathVariable Long id, @RequestBody ProductRequest request);

    @DeleteMapping("/{id}")
    @SecurityRequirement(name = "security token")
    @Operation(description = "Delete an existing Product")
    @Parameter(name = "id", description = "ID of the Product to delete")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Product deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<?> deleteProduct(@PathVariable Long id);
}
