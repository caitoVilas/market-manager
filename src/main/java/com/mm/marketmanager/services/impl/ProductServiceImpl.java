package com.mm.marketmanager.services.impl;

import com.mm.marketmanager.api.exceptions.customs.BadRequestException;
import com.mm.marketmanager.api.exceptions.customs.NotFoundException;
import com.mm.marketmanager.api.models.requests.ProductRequest;
import com.mm.marketmanager.api.models.responses.ProductResponse;
import com.mm.marketmanager.persistence.repositories.ProductRepository;
import com.mm.marketmanager.services.contracts.ProductService;
import com.mm.marketmanager.utils.logs.WriteLogs;
import com.mm.marketmanager.utils.mappers.ProductMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of the ProductService interface for managing products
 * in the Market Manager application.
 *
 * @author caito
 *
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    /**
     * Adds a new product to the system after validating the request data.
     *
     * @param request the product request containing product details
     * @throws BadRequestException if validation fails
     */
    @Override
    @Transactional
    public void addProduct(ProductRequest request) {
        log.info(WriteLogs.logInfo("--> Add Product service"));
        this.validateProduct(request);
        productRepository.save(ProductMapper.mapToEntity(request));
    }

    /**
     * Retrieves a product by its ID.
     *
     * @param id the ID of the product to retrieve
     * @return the product response containing product details
     * @throws NotFoundException if the product is not found
     */
    @Override
    @Transactional(readOnly = true)
    public ProductResponse getProduct(Long id) {
        log.info(WriteLogs.logInfo("--> Get Product service"));
        return ProductMapper.mapToDto(productRepository.findById(id).orElseThrow(
                () -> {
                    log.warn(WriteLogs.logWarning("--> Product with id " + id + " not found."));
                    return new NotFoundException("Product with id " + id + " not found.");
                }));
    }

    /**
     * Retrieves all products in the system.
     *
     * @return a list of product responses containing product details
     */
    @Override
    @Transactional(readOnly = true)
    public List<ProductResponse> getProducts() {
        log.info(WriteLogs.logInfo("--> Get Products service"));
        return productRepository.findAll().stream()
                .map(ProductMapper::mapToDto)
                .toList();
    }

    /**
     * Updates an existing product with new details.
     *
     * @param id      the ID of the product to update
     * @param request the product request containing updated product details
     * @return the updated product response
     * @throws NotFoundException if the product is not found
     */
    @Override
    @Transactional
    public ProductResponse updateProduct(Long id, ProductRequest request) {
        log.info(WriteLogs.logInfo("--> Update Product service"));
        var product = productRepository.findById(id).orElseThrow(
                () -> {
                    log.warn(WriteLogs.logWarning("--> Product with id " + id + " not found."));
                    return new NotFoundException("Product with id " + id + " not found.");
                }
        );
        if (request.getName() != null && !request.getName().isEmpty()) {
            product.setName(request.getName());
        }
        if (request.getCategory() != null && !request.getCategory().isEmpty()) {
            product.setCategory(request.getCategory());
        }
        if (request.getDescription() != null && !request.getDescription().isEmpty()) {
            product.setDescription(request.getDescription());
        }
        if (request.getPrice() != null && request.getPrice() >= 0) {
            product.setPrice(request.getPrice());
        }
        if (request.getStock() != null && request.getStock() >= 0) {
            product.setStock(request.getStock());
        }
        return ProductMapper.mapToDto(productRepository.save(product));
    }

    @Override
    @Transactional
    public void deleteProduct(Long id) {
        log.info(WriteLogs.logInfo("--> Delete Product service"));
        var product = productRepository.findById(id).orElseThrow(
                () -> {
                    log.warn(WriteLogs.logWarning("--> Product with id " + id + " not found."));
                    return new NotFoundException("Product with id " + id + " not found.");
                }
        );
        productRepository.delete(product);

    }

    /**
     * Validates the product request data.
     *
     * @param request the user request to validate
     * @throws BadRequestException if validation fails
     */
    private void validateProduct(ProductRequest request) {
        log.info(WriteLogs.logInfo("--> Validate Product..."));
        List<String> errors = new ArrayList<>();
        if (request.getName() == null || request.getName().isEmpty()) {
            errors.add("Product name is required.");
        }
        if (request.getCategory() == null || request.getCategory().isEmpty()) {
            errors.add("Product category is required.");
        }
        if (request.getPrice() == null || request.getPrice() < 0) {
            errors.add("Product price must be a positive value.");
        }
        if (request.getStock() == null || request.getStock() < 0) {
            errors.add("Product stock must be a non-negative value.");
        }
        if (!errors.isEmpty()) {
            log.error(WriteLogs.logError("Validation errors: " + String.join(", ", errors)));
            throw new BadRequestException(errors);
        }
    }

}
