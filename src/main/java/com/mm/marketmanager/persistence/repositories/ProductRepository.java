package com.mm.marketmanager.persistence.repositories;

import com.mm.marketmanager.persistence.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Repository interface for managing Product entities in the market manager application.
 * Extends JpaRepository to provide CRUD operations and additional JPA functionalities.
 *
 * @author caito
 *
 */
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByCategory(String category);
}
