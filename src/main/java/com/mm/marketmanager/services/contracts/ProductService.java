package com.mm.marketmanager.services.contracts;

import com.mm.marketmanager.api.models.requests.ProductRequest;
import com.mm.marketmanager.api.models.responses.ProductResponse;

import java.util.List;

/**
 * Service contract for managing products in the Market Manager application.
 * Provides methods for adding, retrieving, updating, and deleting products.
 *
 * @author caito
 *
 */
public interface ProductService {
    void addProduct(ProductRequest request);
    ProductResponse getProduct(Long id);
    List<ProductResponse> getProducts();
    ProductResponse updateProduct(Long id, ProductRequest request);
    void deleteProduct(Long id);
}
