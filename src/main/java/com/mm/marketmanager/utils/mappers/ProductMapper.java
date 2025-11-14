package com.mm.marketmanager.utils.mappers;

import com.mm.marketmanager.api.models.requests.ProductRequest;
import com.mm.marketmanager.api.models.responses.ProductResponse;
import com.mm.marketmanager.persistence.entities.Product;

/**
 * Utility class for mapping between ProductRequest, ProductResponse, and Product entity.
 *
 * @author caito
 *
 */
public class ProductMapper {

    /**
     * Maps a ProductRequest to a Product entity.
     *
     * @param request the ProductRequest object
     * @return the mapped Product entity
     */
    public static Product mapToEntity(ProductRequest request){
        return Product.builder()
                .name(request.getName())
                .category(request.getCategory())
                .description(request.getDescription())
                .price(request.getPrice())
                .stock(request.getStock())
                .build();
    }

    /**
     * Maps a Product entity to a ProductResponse.
     *
     * @param product the Product entity
     * @return the mapped ProductResponse object
     */
    public static ProductResponse mapToDto(Product product){
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .category(product.getCategory())
                .description(product.getDescription())
                .price(product.getPrice())
                .stock(product.getStock())
                .build();
    }
}
